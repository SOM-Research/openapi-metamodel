/**
 */
package edu.uoc.som.openapi2.mapping.impl;

import edu.uoc.som.openapi2.mapping.Mapping;
import edu.uoc.som.openapi2.mapping.OpenAPI2MappingPackage;
import edu.uoc.som.openapi2.mapping.PropertyToParameter;
import edu.uoc.som.openapi2.mapping.PropertyToProperty;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.openapi2.mapping.impl.MappingImpl#getPropertyToParameterMappings <em>Property To Parameter Mappings</em>}</li>
 *   <li>{@link edu.uoc.som.openapi2.mapping.impl.MappingImpl#getPropertyToPropertyMappings <em>Property To Property Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends MinimalEObjectImpl.Container implements Mapping {
	/**
	 * The cached value of the '{@link #getPropertyToParameterMappings() <em>Property To Parameter Mappings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyToParameterMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyToParameter> propertyToParameterMappings;

	/**
	 * The cached value of the '{@link #getPropertyToPropertyMappings() <em>Property To Property Mappings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyToPropertyMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyToProperty> propertyToPropertyMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OpenAPI2MappingPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyToParameter> getPropertyToParameterMappings() {
		if (propertyToParameterMappings == null) {
			propertyToParameterMappings = new EObjectResolvingEList<PropertyToParameter>(PropertyToParameter.class, this, OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PARAMETER_MAPPINGS);
		}
		return propertyToParameterMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyToProperty> getPropertyToPropertyMappings() {
		if (propertyToPropertyMappings == null) {
			propertyToPropertyMappings = new EObjectResolvingEList<PropertyToProperty>(PropertyToProperty.class, this, OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PROPERTY_MAPPINGS);
		}
		return propertyToPropertyMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PARAMETER_MAPPINGS:
				return getPropertyToParameterMappings();
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PROPERTY_MAPPINGS:
				return getPropertyToPropertyMappings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PARAMETER_MAPPINGS:
				getPropertyToParameterMappings().clear();
				getPropertyToParameterMappings().addAll((Collection<? extends PropertyToParameter>)newValue);
				return;
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PROPERTY_MAPPINGS:
				getPropertyToPropertyMappings().clear();
				getPropertyToPropertyMappings().addAll((Collection<? extends PropertyToProperty>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PARAMETER_MAPPINGS:
				getPropertyToParameterMappings().clear();
				return;
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PROPERTY_MAPPINGS:
				getPropertyToPropertyMappings().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PARAMETER_MAPPINGS:
				return propertyToParameterMappings != null && !propertyToParameterMappings.isEmpty();
			case OpenAPI2MappingPackage.MAPPING__PROPERTY_TO_PROPERTY_MAPPINGS:
				return propertyToPropertyMappings != null && !propertyToPropertyMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingImpl
