package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's street in the address book.
 */
public class Street {
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Street name should be alphanumeric.";
    public static final String STREET_VALIDATION_REGEX = "[a-zA-Z0-9 ]+";
    private final String _streetName;

    /**
     * Validates given street name.
     *
     * @throws IllegalValueException if given street name is invalid.
     */
    public Street(String streetName) throws IllegalValueException {
        if (!isValidStreet(streetName)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this._streetName = streetName;
    }

    /**
     * Returns true if a given string is a valid street name.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    /**
     * Returns street name.
     */
    public String toString() {
        return _streetName;
    }
}
