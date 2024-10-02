package io.codeforall.fanSTATICs;

public class Main {

    public static void main(String[] args) {


        Lamp lamp1 = new Lamp(2);
        Lamp lamp2 = new Lamp(4);



        Genie genie1 = lamp1.rub();
        genie1.wish();
        genie1.wish();
        genie1.wish();
        genie1.wish();
        Genie genie2 = lamp1.rub();
        genie2.wish();
        genie2.wish();
        genie2.wish();
        genie2.wish();
        Genie genie3 = lamp1.rub();
        genie3.wish();
        genie3.wish();
        genie3.wish();
        genie3.wish();
        System.out.println("======================================================");
        lamp1.recycle();
        System.out.println("======================================================");

        //lamp1.compare(lamp2);






    }
}
