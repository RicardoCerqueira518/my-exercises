package io.codeforall.fanstatics;

public class Person {

    private String name;
    private Bank personMoney;


    public String getName() {
        return name;
    }

   public Person (String name, Bank personMoney){
        this.name = name;
        this.personMoney = personMoney;
   }

   public void withdrawValue(double withdraw) {
        personMoney.withdraw(withdraw);
   }

   public void depositValue(double deposit) {
        personMoney.deposit(deposit);
   }


}
