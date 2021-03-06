package edu.uoc.som.openapi2.commons;

import java.util.Map;
import java.util.Objects;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

import edu.uoc.som.openapi2.API;
import edu.uoc.som.openapi2.Operation;
import edu.uoc.som.openapi2.Parameter;
import edu.uoc.som.openapi2.Property;
import edu.uoc.som.openapi2.Schema;
import edu.uoc.som.openapi2.commons.comparators.AbstractComparator;
import edu.uoc.som.openapi2.commons.comparators.BasicComparator;
import edu.uoc.som.openapi2.mapping.Mapping;
import edu.uoc.som.openapi2.mapping.OpenAPI2MappingFactory;
import edu.uoc.som.openapi2.mapping.PropertyToParameter;
import edu.uoc.som.openapi2.mapping.PropertyToProperty;

public class Heuristics {

	public static OpenAPI2MappingFactory factory = OpenAPI2MappingFactory.eINSTANCE;

	/**
	 * Discovers links between the properties and the parameters
	 * 
	 * @param api source API
	 * @return a {@link Mapping} instance holding the discovered links
	 */
	public static Mapping discoverLinks(Schema defintion, API api) {
		Mapping mapping = factory.createMapping();

		for (Map.Entry<String, Schema> sourceDefinition : api.getDefinitions()) {
			List<PropertyToProperty> propertyToPropertyMappings = discoverPropertyLinks(sourceDefinition,api);
			mapping.getPropertyToPropertyMappings().addAll(propertyToPropertyMappings);
			List<PropertyToParameter> propertyToParameterMappings = discoverParameterLinks(sourceDefinition,api);
			mapping.getPropertyToParameterMappings().addAll(propertyToParameterMappings);

		}
		return mapping;

	}

	public static List<PropertyToProperty> discoverPropertyLinks( Map.Entry<String, Schema> sourceDefinition, API api) {
		List<PropertyToProperty> propertToProperties  = new ArrayList<PropertyToProperty>();
		for (Property sourceSchemaProperty : sourceDefinition.getValue().getProperties()) {
			// We compare properties with properties;
			propertToProperties.addAll(discoverPropertyLinks(sourceSchemaProperty,sourceDefinition, api));
			
		}
		return propertToProperties;
	}

	public static List<PropertyToParameter> discoverParameterLinks( Map.Entry<String, Schema> sourceDefinition, API api) {
		List<PropertyToParameter> propertToParameters  = new ArrayList<PropertyToParameter>();
		for (Property sourceSchemaProperty : sourceDefinition.getValue().getProperties()) {
			// We compare properties with properties;
			propertToParameters.addAll(discoverParameterLinks(sourceSchemaProperty,sourceDefinition, api));

		}
		return propertToParameters;
	}
	public static List<PropertyToProperty> discoverPropertyLinks(Property sourceSchemaProperty, Map.Entry<String, Schema> sourceDefinition, API api) {
		 List<PropertyToProperty> propertyToProperties = new ArrayList<PropertyToProperty>();
		for (Map.Entry<String, Schema> targetDefinition : api.getDefinitions()) {
			for (Property targetSchemaProperty : targetDefinition.getValue().getProperties()) {

				if (!sourceSchemaProperty.equals(targetSchemaProperty) &&areSimilar(sourceSchemaProperty, targetSchemaProperty,
						new BasicComparator(sourceDefinition.getKey(), null, true))) {
					PropertyToProperty propertyToProperty = factory.createPropertyToProperty();
					propertyToProperty.setSource(sourceSchemaProperty);
					propertyToProperty.setTarget(targetSchemaProperty);
					propertyToProperties.add(propertyToProperty);
				}
			}
		}
		return propertyToProperties;
	}
	public static List<PropertyToParameter> discoverParameterLinks(Property sourceSchemaProperty, Map.Entry<String, Schema> sourceDefinition, API api) {
		List<PropertyToParameter> propertyToParameters = new ArrayList<PropertyToParameter>();
		for (Operation operation : api.getAllOperations())
			for (Parameter parameter : operation.getParameters()) {
				if (areSimilar(sourceSchemaProperty, parameter,
						new BasicComparator(sourceDefinition.getKey(), null, false))) {
					PropertyToParameter propertyToParameter = factory.createPropertyToParameter();
					propertyToParameter.setSource(sourceSchemaProperty);
					propertyToParameter.setTarget(parameter);
					propertyToParameters.add(propertyToParameter);
				}
			}
		return propertyToParameters;
	}

	

	public static boolean areSimilar(Property source, Property target, AbstractComparator comparator) {

		if (Objects.compare(source.getName(), target.getName(), comparator) == 0) {
			if (nonNull(source.getSchema()) && nonNull(source.getSchema().getType()) && nonNull(target.getSchema())
					&& nonNull(target.getSchema().getType())) {
				Schema sourceSchema = source.getSchema();
				Schema targetSchema = target.getSchema();
				if (OpenAPIUtils.isSingleValuedPrimitive(sourceSchema)
						&& OpenAPIUtils.isSingleValuedPrimitive(targetSchema)) {
					if (sourceSchema.getType().equals(targetSchema.getType())) {
						if (isNull(sourceSchema.getFormat()) && isNull(targetSchema.getFormat())) {
							return true;
						} else {
							if (nonNull(sourceSchema.getFormat()) && nonNull(targetSchema.getFormat())
									&& sourceSchema.getFormat().equals(targetSchema.getFormat()))
								return true;
						}
					}
				}
			// TODO array/array && primitive/array
			}
		}

		return false;

	}
	
	public static boolean areSimilar(Property sourceProperty, Parameter targetParameter, AbstractComparator comparator) {

		if (Objects.compare(sourceProperty.getName(), targetParameter.getName(), comparator) == 0) {
			if (nonNull(sourceProperty.getSchema()) && nonNull(sourceProperty.getSchema().getType())) {
				Schema sourceSchema = sourceProperty.getSchema();
				if (OpenAPIUtils.isSingleValuedPrimitive(sourceSchema)
						&& OpenAPIUtils.isSingleValuedPrimitive(targetParameter)) {
					if (sourceSchema.getType().equals(targetParameter.getType())) {
						if (isNull(sourceSchema.getFormat()) && isNull(targetParameter.getFormat())) {
							return true;
						} else {
							if (nonNull(sourceSchema.getFormat()) && nonNull(targetParameter.getFormat())
									&& sourceSchema.getFormat().equals(targetParameter.getFormat()))
								return true;
						}
					}
				}
				if (OpenAPIUtils.isSingleValuedPrimitive(sourceSchema)
						&& OpenAPIUtils.isArrayOfPrimitives(targetParameter)) {
					if (sourceSchema.getType().equals(targetParameter.getItems().getType())) {
						if (isNull(sourceSchema.getFormat()) && isNull(targetParameter.getItems().getFormat())) {
							return true;
						} else {
							if (nonNull(sourceSchema.getFormat()) && nonNull(targetParameter.getItems().getFormat())
									&& sourceSchema.getFormat().equals(targetParameter.getItems().getFormat()))
								return true;
						}
					}
					
				}
			}
		}

		return false;

	}
	
	
}
