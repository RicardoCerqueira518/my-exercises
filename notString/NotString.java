public class NotString{

public static void main(String[] args) {

    String word = "semicolon"; // what if the word is "nothing"?
 String word2 = word.substring(0,3);

   System.out.println((word2 == "not") ? word : ("not"+word));

}
  
}
