package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents the adding or deleting of a tag for a specific person that happened during that session. 
 * An array of Tagging objects will be stored in AddressBook.
 */
public class Tagging {
    
    private Tag tag;
    private Person person;
    private Operation operation;
    
    /**
     * Operations for tags.
     */
    public enum Operation { 
        ADD("+"), DELETE("-"); 
        
        private final String operator; 
        
        private Operation(final String operator) {
            this.operator = operator;
        }
        
        public String toString() {
            return this.operator;
        }
    };

    public Tagging(Tag tag, Person person, Operation operation) {
        this.tag = tag;
        this.person = person;
        this.operation = operation;
    }
    
    public Tag getTag() {
        return tag;
    }

    public Person getPerson() {
        return person;
    }

    public Operation getOperation() {
        return operation;
    }
    
    /**
     * Returns a string in the following format
     * <operator> <fullName> [<tag>]
     * i.e. + Jake Woo [friend]
     */
    public String toString() {
        return getOperation().toString() + " " + getPerson().getName() + " " + getTag().toString();
    }

}
