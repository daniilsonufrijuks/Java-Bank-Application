package test.java.com.bankapp.controller;

import org.junit.Test;
import controller.BankAccountManager;

public class BankAccountManagerTest {
    
    @Test
    public void SendMoneyTest(){
        String lineToUpdate = "3, Vaas, Far, 123456-123456, 65f644d5dfd77654334d5f677df76554, vaas@gmail.com, VaasFC, 1234567, 1234566, 0";
        String[] lineToUpdParsed = lineToUpdate.split(", ");
        float money = 20.0f;
        System.out.println(lineToUpdParsed);

        BankAccountManager.SendMoney("VaasFC", "vaas@gmail.com", money);
    }

    // @Test
    // public void GetBalanceTest(){
    //     BankAccountManager.GetBalance();        // it works!!!
    // }

}
