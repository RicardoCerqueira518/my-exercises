package io.codeforall.fanstatics;

public class Bank {

    private double  personMoney;
    public String bankName;


    public Bank (String bankName, double personMoney){
         this.bankName = bankName;
         this.personMoney = personMoney;
    }


    public double withdraw (double withdrawValue) {


            if (withdrawValue <= this.personMoney) {
                System.out.println("Your actual account money is: " + (this.personMoney -= withdrawValue));
                return this.personMoney -= withdrawValue;
        } else {
            System.out.println("You don't have enough money");
            return this.personMoney;
        }
    }

    public double deposit (double depositValue) {
        System.out.println("Your actual account money is: " + (this.personMoney += depositValue));
        return this.personMoney += depositValue;
    }



}
