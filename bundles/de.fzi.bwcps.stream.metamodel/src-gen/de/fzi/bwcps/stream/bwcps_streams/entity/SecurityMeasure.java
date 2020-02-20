/**
 */
package de.fzi.bwcps.stream.bwcps_streams.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Security Measure</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage#getSecurityMeasure()
 * @model
 * @generated
 */
public enum SecurityMeasure implements Enumerator {
	/**
	 * The '<em><b>ENCRYPT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_VALUE
	 * @generated
	 * @ordered
	 */
	ENCRYPT(0, "ENCRYPT", "ENCRYPT"),

	/**
	 * The '<em><b>AUTHENTICATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATE_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHENTICATE(1, "AUTHENTICATE", "AUTHENTICATE"),

	/**
	 * The '<em><b>ENC THEN AUTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENC_THEN_AUTH_VALUE
	 * @generated
	 * @ordered
	 */
	ENC_THEN_AUTH(2, "ENC_THEN_AUTH", "ENC_THEN_AUTH"),

	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(3, "NONE", "NONE");

	/**
	 * The '<em><b>ENCRYPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENCRYPT_VALUE = 0;

	/**
	 * The '<em><b>AUTHENTICATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUTHENTICATE_VALUE = 1;

	/**
	 * The '<em><b>ENC THEN AUTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENC_THEN_AUTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENC_THEN_AUTH_VALUE = 2;

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Security Measure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SecurityMeasure[] VALUES_ARRAY = new SecurityMeasure[] { ENCRYPT, AUTHENTICATE, ENC_THEN_AUTH,
			NONE, };

	/**
	 * A public read-only list of all the '<em><b>Security Measure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SecurityMeasure> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Security Measure</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SecurityMeasure get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SecurityMeasure result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Security Measure</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SecurityMeasure getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SecurityMeasure result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Security Measure</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SecurityMeasure get(int value) {
		switch (value) {
		case ENCRYPT_VALUE:
			return ENCRYPT;
		case AUTHENTICATE_VALUE:
			return AUTHENTICATE;
		case ENC_THEN_AUTH_VALUE:
			return ENC_THEN_AUTH;
		case NONE_VALUE:
			return NONE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SecurityMeasure(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //SecurityMeasure
