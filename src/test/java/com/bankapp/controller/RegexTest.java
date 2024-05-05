package test.java.com.bankapp.controller;

// import static org.junit.Assert.assertEquals;

// import org.junit.Test;

import regex.*;

//import lib.org.junit.Test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RegexTest {
    
    @Test
    public void RegexNamePCodeEmailTest() {
        String name = "Vasya";
        String lname = "Pupkin";
        String pscode = "123456-12345";
        String email = "prodamgaraz@gmail.com";

        assertEquals(true, REGEXManager.NameRegex(name));
        assertEquals(true, REGEXManager.NameRegex(lname));
        assertEquals(true, REGEXManager.PersoncodeRegex(pscode));
        assertEquals(true, REGEXManager.EmailRegex(email));
    }

    @Test
    public void RegexIsValidFloatTest(){
        assertEquals(true, REGEXManager.isValidFloat("20"));
        assertEquals(true, REGEXManager.isValidFloat("20.00"));
        assertEquals(true, REGEXManager.isValidFloat("20.01"));
        assertEquals(true, REGEXManager.isValidFloat("20.10"));
        assertEquals(true, REGEXManager.isValidFloat("20.1"));
        assertEquals(true, REGEXManager.isValidFloat("20.22"));
        assertEquals(false, REGEXManager.isValidFloat("20.222"));
        // test for zero (0) value is made in SendMoneyTest.java
        assertEquals(false, REGEXManager.isValidFloat("-2"));
        assertEquals(false, REGEXManager.isValidFloat("-2.02"));
        assertEquals(false, REGEXManager.isValidFloat("-2.22"));
    }

    @Test
    public void RegexIsNumberTest(){
        assertEquals(true, REGEXManager.isNumber("1"));
        assertEquals(true, REGEXManager.isNumber("1.0"));
        assertEquals(true, REGEXManager.isNumber("1.01"));
        assertEquals(false, REGEXManager.isNumber("a"));
        assertEquals(false, REGEXManager.isNumber("1,0"));
    }
}
