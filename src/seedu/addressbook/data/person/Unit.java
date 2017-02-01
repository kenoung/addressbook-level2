package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit in the address book.
 */
public class Unit {
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Unit number should start with a hex.";
    public static final String UNIT_VALIDATION_REGEX = "#[0-9]{2}-[0-9]{2}";
    private final String _unitNumber;

    /**
     * Validates given unit number.
     *
     * @throws IllegalValueException if given unit number is invalid.
     */
    public Unit(String unitNumber) throws IllegalValueException {
        if (!isValidUnit(unitNumber)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this._unitNumber = unitNumber;
    }

    /**
     * Returns true if a given string is a valid unit number.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    /**
     * Returns unit number.
     */
    public String toString() {
        return _unitNumber;
    }
}

