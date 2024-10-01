package io.codeforall.fanstatics;

public class Sandbox {

    public static void main(String[] args) {

        Bank bankAccount1 = new Bank("Montepio", 500.00);
        Person person1 = new Person("Ricardo",bankAccount1);

        Bank bankAccount2 = new Bank("Caixa", 5000);
        Person person2 = new Person("Gonçalo", bankAccount2);

        person1.withdrawValue(499.00);
        person1.depositValue(100);
        person1.withdrawValue(1000);

        person2.withdrawValue(200);
        person2.depositValue(20);

    }
    

}
