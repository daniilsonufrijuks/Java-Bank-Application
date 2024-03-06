package tests;
import src.REGEXManager;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class RegexTest {
    @Test
    public void RegexNamePCodeEmailTest() {
        String name = "Vasya";
        String lname = "Pupkin";
        String pscode = "123456-123456";
        String email = "prodamgaraz@gmail.com";

        assertEquals(true, REGEXManager.NameRegex(name));
        assertEquals(true, REGEXManager.NameRegex(lname));
        assertEquals(true, REGEXManager.PersoncodeRegex(pscode));
        assertEquals(true, REGEXManager.EmailRegex(email));
    }
}
