package io.codeforall.fanstatics;


public class Machine {

    public static void main(String[] args) {

        MonoOperation <Integer> increment = (n) -> n + 1;
        int result = increment.execute(5);
        System.out.println(result);

        BioOperation <String> concatenate = (string1, string2) -> string1 + string2;
        String resultString = concatenate.execute("Ricardo", " is cool");
        System.out.println(resultString);


    }

}
