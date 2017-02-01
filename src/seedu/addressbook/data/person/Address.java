package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must entered in the "
            + "following format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLIT_REGEX = ",";

    // Address is represented as an array of 4 elements.
    private static final int NUMBER_OF_ADDRESS_ELEMENTS = 4;
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_CODE_INDEX = 3;
    
    public final String _address;
    public final String[] _addressArray;
    private final Block blockNumber;
    private final Street streetName;
    private final Unit unitNumber;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        this._address = address;
        this._addressArray = address.split(ADDRESS_SPLIT_REGEX);
        
        if (!isValidAddress(address) || _addressArray.length != NUMBER_OF_ADDRESS_ELEMENTS) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        try {
            this.blockNumber = new Block(this._addressArray[BLOCK_INDEX]);
            this.streetName = new Street(this._addressArray[STREET_INDEX]);
            this.unitNumber = new Unit(this._addressArray[UNIT_INDEX]);
            this.postalCode = new PostalCode(this._addressArray[POSTAL_CODE_INDEX]);
        } catch (IllegalValueException e) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS + e);
        }
        
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return _address;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this._address.equals(((Address) other)._address)); // state check
    }

    @Override
    public int hashCode() {
        return _address.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * @return the blockNumber
     */
    public String getBlockNumber() {
        return blockNumber.toString();
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName.toString();
    }

    /**
     * @return the unitNumber
     */
    public String getUnitNumber() {
        return unitNumber.toString();
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode.toString();
    }
}