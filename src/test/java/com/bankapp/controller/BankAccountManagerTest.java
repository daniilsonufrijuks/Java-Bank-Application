package test.java.com.bankapp.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import managers.BankAccountManager;
import model.Transaction;

public class BankAccountManagerTest {
    
    @Test
    public void SendMoneyTest(){
        // float money = 20.2f;
        // Transaction transaction = new Transaction(money, "65f644d5dfd77654334d5f677df76554", "VaasFC");
        // BankAccountManager.SendMoney(transaction);
        // money = 0.02f;
        // BankAccountManager.SendMoney(transaction);
        // money = 1.02f;
        // BankAccountManager.SendMoney(transaction);
    }

    @Test
    public void GetBalanceTest(){
        System.out.println(BankAccountManager.GetBalance("123457-12345"));  // it works
    }

    @Test
    public void CheckSendDataTest(){
        assertEquals(true, BankAccountManager.CheckSendData("VaasFC", "65f644d5dfd77654334d5f677df76554", 20.2f, "123456-12345"));
        assertEquals(true, BankAccountManager.CheckSendData("Don", "7b493791a0684f1daf5fa8ea80626123", 20.01f, "111122-20779"));
        assertEquals(false, BankAccountManager.CheckSendData("Don", "-", 20.01f, "111122-20779"));
        assertEquals(false, BankAccountManager.CheckSendData("-dtyio", "7b493791a0684f1daf5fa8ea80626123", 20.01f, "111122-20779"));
    }

    @Test
    public void RemoveMoneyFromSenderInCSVAfterSendMoneyTest(){
        //BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney("123457-12345", "vaas@gmail.com", 7.23f);
    }

    @Test
    public void FindBankAccountTest(){
        assertEquals("be39b4477c234e22bde26189493cd0bc", BankAccountManager.FindBankAccount("123456-12345"));
        assertEquals("65f644d5dfd77654334d5f677df76554", BankAccountManager.FindBankAccount("123457-12345"));
    }
}
