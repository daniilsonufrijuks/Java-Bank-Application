package test.java.com.bankapp.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import managers.CreditManager;

public class CreditManagerTest {
    @Test
    public void GenCreditTest() {
        float money = 1000.0f;
        float percents = 10.0f;
        int years = 1;
        assertEquals(1100.0f, CreditManager.GenCredit(money, percents, years), 0);
    }
}
