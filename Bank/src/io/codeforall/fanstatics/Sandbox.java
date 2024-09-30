package io.codeforall.fanstatics;

public class Sandbox {

    public static void main(String[] args) {

        Bank bank1 = new Bank("Montepio", 500.00);
        Person person1 = new Person("Ricardo",bank1);

        Bank bank2 = new Bank("Caixa", 5000);
        Person person2 = new Person("Gonçalo", bank2);

        person1.personWithdraw(501.00);
        person1.personDeposit(10);
        person1.personWithdraw(1000);

        person2.personWithdraw(200);
        person2.personDeposit(20);




    }




}
