package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's postal code in the address book.
 */
public class PostalCode {
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Postal code should consist of 6 digits i.e. 130998";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "[0-9]{6}";
    private final String _postalCode;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this._postalCode = postalCode;
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    /**
     * Returns postal code.
     */
    public String toString() {
        return _postalCode;
    }
}

