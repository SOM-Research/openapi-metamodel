/**
 */
package flow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Transfer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link flow.PropertyTransfer#getSource <em>Source</em>}</li>
 *   <li>{@link flow.PropertyTransfer#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see flow.FlowPackage#getPropertyTransfer()
 * @model
 * @generated
 */
public interface PropertyTransfer extends Step {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Property)
	 * @see flow.FlowPackage#getPropertyTransfer_Source()
	 * @model
	 * @generated
	 */
	Property getSource();

	/**
	 * Sets the value of the '{@link flow.PropertyTransfer#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Property value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Property)
	 * @see flow.FlowPackage#getPropertyTransfer_Target()
	 * @model
	 * @generated
	 */
	Property getTarget();

	/**
	 * Sets the value of the '{@link flow.PropertyTransfer#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Property value);

} // PropertyTransfer
