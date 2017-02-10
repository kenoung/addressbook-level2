package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if they have at least 2 matching word tokens.
     * This function is case-insensitive. 
     * @throws IllegalValueException when input name is null
     */
     public boolean isSimilar(Name other) throws IllegalValueException {
         if (other == null) {
             throw new IllegalValueException("Other name cannot be null.");
         }
         return numberOfMatchingTokens(this.fullName, other.fullName) >= 2;
     }

    private int numberOfMatchingTokens(String firstName, String secondName) {
        int numberOfMatchingTokens = 0;
        for (String token : firstName.split(" ")) {
            if (Arrays.asList(secondName.split(" ")).contains(token)) {
                numberOfMatchingTokens++;
            }
        }
        return numberOfMatchingTokens;
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
