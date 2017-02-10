package seedu.addressbook.data.person;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    private Name name;
    
    @Before
    public void setup() throws IllegalValueException {
        name = new Name("Ken Oung Yong Quan");
    }    

    @Test
    public void isSimilar_sameName_returnsTrue() throws IllegalValueException {
        Name otherName = new Name("Ken Oung Yong Quan");
        assertTrue(name.isSimilar(otherName));
    }

}
