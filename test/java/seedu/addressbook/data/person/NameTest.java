package seedu.addressbook.data.person;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    private Name name;
    
    @Before
    public void setup() throws IllegalValueException {
        name = new Name("Ken Oung Yong Quan");
    }     

    @Test(expected= IllegalValueException.class)
    public void isSimilar_nullInput_failsSimilarityCheck() throws IllegalValueException {
        boolean result = name.isSimilar(null);
    }   

    @Test
    public void isSimilar_sameName_returnsTrue() throws IllegalValueException {
        Name otherName = new Name("Ken Oung Yong Quan");
        assertTrue(name.isSimilar(otherName));
    }    

    @Test
    public void isSimilar_matchFirstTwoTokens_returnsTrue() throws IllegalValueException {
        Name otherName = new Name("Ken Oung");
        assertTrue(name.isSimilar(otherName));
    }    

    @Test
    public void isSimilar_onlyOneMatch_failsSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Ken");
        assertFalse(name.isSimilar(otherName));
    }

}
