package test.java.com.bankapp.controller;

import org.junit.Test;

public class CreditManagerTest {
    @Test
    public void GenCreditTest() {
        float money = 1000.0f;
        float percents = 10.0f;
        int years = 1;
        float credit = 0.0f;
        if (money > 0) {
            credit = (float) (money * Math.pow(1 + percents / 100, years));
        }
        assert credit == 1100.0f;
    }
}
