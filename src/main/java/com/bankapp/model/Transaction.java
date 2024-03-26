package model;

public class Transaction {
    private float amount;
    private String bankaccount;
    private String username;

    public Transaction(float Newamount, String Newbankaccount, String Newusername) {
        this.amount = Newamount;
        this.bankaccount = Newbankaccount;
        this.username = Newusername;
    }

    // Getters and Setters

    public float getAmount() {
        return amount;
    }

    public void setAmount(float Newamount) {
        this.amount = Newamount;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String Newbankaccount) {
        this.bankaccount = Newbankaccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Newusername) {
        this.username = Newusername;
    }

}
