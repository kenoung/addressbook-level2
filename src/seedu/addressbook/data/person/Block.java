package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block in the address book.
 */
public class Block {
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Block number should be numeric.";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";
    private String _block;

    /**
     * Validates given block number.
     *
     * @throws IllegalValueException if given block number is invalid.
     */
    public Block(String blockNumber) throws IllegalValueException {
        if (!isValidBlock(blockNumber)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.setBlock(blockNumber);
    }

    /**
     * Returns true if a given string is a valid block number.
     */
    public static boolean isValidBlock(String test) {
        return test.isEmpty() || test.matches(BLOCK_VALIDATION_REGEX);
    }

    /**
     * @return the _block
     */
    public String getBlock() {
        return _block;
    }

    /**
     * @param blockNumber the blockNumber to set
     * @throws IllegalValueException  if given blockNumber is invalid.
     */
    public void setBlock(String blockNumber) throws IllegalValueException {
        if (!isValidBlock(blockNumber)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this._block = blockNumber;
    }

}
