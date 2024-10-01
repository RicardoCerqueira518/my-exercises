package io.codeforall.fanstatics;

public class Bank {

    private double  personMoney;
    public String bankName;


    public Bank (String bankName, double personMoney){
         this.bankName = bankName;
         this.personMoney = personMoney;
    }


    public double withdraw (double withdrawValue) {
        if (withdrawValue > 0 && withdrawValue <= this.personMoney) {
            System.out.println("Withdraw value = " + withdrawValue + "€. Your actual balance is: " + (this.personMoney -= withdrawValue));
            return this.personMoney -= withdrawValue;
        }

        System.out.println("Not possible to withdraw the chosen value");
        return this.personMoney;

    }

    public void deposit (double depositValue) {
        if (depositValue > 0) {
            System.out.println("Deposit value = " + depositValue +"€. Your actual balance is: " + (this.personMoney += depositValue));
            this.personMoney += depositValue;
            return;
        }
        System.out.println("Not possible to deposit under 1€");
    }


}
