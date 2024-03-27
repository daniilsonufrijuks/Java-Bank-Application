package test.java.com.bankapp.controller;

import org.junit.Test;

import managers.BankAccountManager;
import model.Transaction;

public class BankAccountManagerTest {
    
    @Test
    public void SendMoneyTest(){
        String lineToUpdate = "3, Vaas, Far, 123456-123456, 65f644d5dfd77654334d5f677df76554, vaas@gmail.com, VaasFC, 1234567, 1234566, 0";
        String[] lineToUpdParsed = lineToUpdate.split(", ");
        float money = 20.2f;
        System.out.println(lineToUpdParsed);
        Transaction transaction = new Transaction(money, "65f644d5dfd77654334d5f677df76554", "VaasFC");
        BankAccountManager.SendMoney(transaction);
        // money = 20.42f;
        // BankAccountManager.SendMoney("VaasFC", "65f644d5dfd77654334d5f677df76554", money);
        // money = 20.55f;
        // BankAccountManager.SendMoney("VaasFC", "65f644d5dfd77654334d5f677df76554", money);
    }

    // @Test
    // public void GetBalanceTest(){
    //     BankAccountManager.GetBalance();        // it works!!!
    // }

}
