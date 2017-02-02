package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's street in the address book.
 */
public class Street {
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Street name should be alphanumeric.";
    public static final String STREET_VALIDATION_REGEX = "[a-zA-Z0-9 ]+";
    private String _streetName;

    /**
     * Validates given street name.
     *
     * @throws IllegalValueException if given street name is invalid.
     */
    public Street(String streetName) throws IllegalValueException {
        if (!isValidStreet(streetName)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.setStreetName(streetName);
    }

    /**
     * Returns true if a given string is a valid street name.
     */
    public static boolean isValidStreet(String test) {
        return test.isEmpty() || test.matches(STREET_VALIDATION_REGEX);
    }

    /**
     * @return the _streetName
     */
    public String getStreetName() {
        return _streetName;
    }

    /**
     * @param streetName the streetName to set
     * @throws IllegalValueException if given street name is valid
     */
    public void setStreetName(String streetName) throws IllegalValueException {
        if (!isValidStreet(streetName)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this._streetName = streetName;
    }
}
