package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents the adding or deleting of a tag for a specific person that happened during that session. 
 * An array of Tagging objects will be stored in AddressBook.
 */
public class Tagging {
    
    public enum Operation { ADD, DELETE };
    private Tag tag;
    private Person person;
    private Operation operation;

    public Tagging(Tag tag, Person person, Operation operation) {
        this.tag = tag;
        this.person = person;
        this.operation = operation;
    }

}
