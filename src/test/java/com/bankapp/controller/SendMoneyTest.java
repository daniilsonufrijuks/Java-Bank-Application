package test.java.com.bankapp.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.BankAccountManager;
import controller.REGEXManager;

public class SendMoneyTest {        // Unit Test for methods and conditions used in GUIMainProgram.java for SendMoney
    
    @Test
    public void CheckMoneyToSend(){
        String recUsername = "Don";
        String recBankAccount = "7b493791a0684f1daf5fa8ea80626123";
        String userPCode = "123456-12345";

        float moneyToSend1 = 20;    // ok
        float moneyToSend2 = 20.0f; // ok
        float moneyToSend3 = 20.12f;    // ok
        float moneyToSend4 = 20.02f;    // ok
        float moneyToSend5 = 40;    // not ok   (capital = 30)
        float moneyToSend6 = 0;     // not ok
        float moneyToSend7 = 0.00f; // not ok
        float moneyToSend8 = -2;    // not ok
        float moneyToSend9 = -2.02f;     // not ok

        assertEquals(true, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend1, userPCode));
        assertEquals(true, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend2, userPCode));
        assertEquals(true, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend3, userPCode));
        assertEquals(true, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend4, userPCode));
        assertEquals(false, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend5, userPCode));
        assertEquals(false, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend6, userPCode));
        assertEquals(false, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend7, userPCode));
        assertEquals(false, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend8, userPCode));
        assertEquals(false, CheckSendDataAndMoney(recUsername, recBankAccount, moneyToSend9, userPCode));
    }

    // block of code from GUIMainProgram.java that uses methods from BankAccountManager.java and REGEXManager.java
    public boolean CheckSendDataAndMoney(String recUsername, String recBankAccount, float moneyToSend, String userpCode){
        if (BankAccountManager.CheckSendData(recUsername, recBankAccount, moneyToSend, userpCode)){
            if (REGEXManager.isValidFloat(String.valueOf(moneyToSend)) && moneyToSend != 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
