package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's postal code in the address book.
 */
public class PostalCode {
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Postal code should consist of 6 digits i.e. 130998";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "[0-9]{6}";
    private String _postalCode;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.setPostalCode(postalCode);
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostalCode(String test) {
        return test.isEmpty() || test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    /**
     * @return the _postalCode
     */
    public String getPostalCode() {
        return _postalCode;
    }

    /**
     * @param _postalCode the _postalCode to set
     * @throws IllegalValueException if given postal code is invalid.
     */
    public void setPostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this._postalCode = postalCode;
    }
}

