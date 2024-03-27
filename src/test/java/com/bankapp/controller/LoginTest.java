package test.java.com.bankapp.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import logreg.Login;

public class LoginTest {
    @Test
    public void LoginMethodTest(){
        String name1 = "Mark";
        String lastname1 = "Cen";
        String pcode1 = "123456-12345";
        String email1 = "mkc@gmail.com";
        String nickname1 = "Mcen";
        // is valid
        assertEquals(true, Login.login(name1, lastname1, pcode1, email1, nickname1));

        name1 = "Alex";
        // not valid
        assertEquals(false, Login.login(name1, lastname1, pcode1, email1, nickname1));
    }
}
