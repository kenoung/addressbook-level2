package seedu.addressbook.data.person;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    private Name name;
    
    @Before
    public void setup() throws IllegalValueException {
        name = new Name("Ken Oung Yong Quan");
    }     

    @Test(expected= IllegalValueException.class)
    public void isSimilar_nullInput_throwException() throws IllegalValueException {
        name.isSimilar(null);
    }   

    @Test
    public void isSimilar_sameName_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Ken Oung Yong Quan");
        assertTrue(name.isSimilar(otherName));
    }    

    @Test
    public void isSimilar_sameNameButLowercase_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("ken oung yong quan");
        assertTrue(name.isSimilar(otherName));
    }        

    @Test
    public void isSimilar_changeOrder_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Oung Yong Quan Ken");
        assertTrue(name.isSimilar(otherName));
    }            

    @Test
    public void isSimilar_longerName_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Ken Oung Yong Quan The Great");
        assertTrue(name.isSimilar(otherName));
    }    

    @Test
    public void isSimilar_matchFirstTwoTokens_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Ken Oung");
        assertTrue(name.isSimilar(otherName));
    }        

    @Test
    public void isSimilar_matchLastTwoTokens_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Yong Quan");
        assertTrue(name.isSimilar(otherName));
    }          

    @Test
    public void isSimilar_nonConsecutiveTwoTokens_passSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Ken Quan");
        assertTrue(name.isSimilar(otherName));
    }    

    @Test
    public void isSimilar_onlyOneMatch_failsSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("Ken");
        assertFalse(name.isSimilar(otherName));
    } 

    @Test
    public void isSimilar_differentName_failsSimilarityTest() throws IllegalValueException {
        Name otherName = new Name("John Smith");
        assertFalse(name.isSimilar(otherName));
    }

}
