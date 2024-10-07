public class StringManipulations {
	
	public static void main(String[] args) {

		String str = "http://www.academiadecodigo.org";

String domain = str.substring(7,31); // www.academiadecodigo.org
String name1 = str.substring(11,27);   // academiadecodigo
String name2 = (name1.substring(0,8))+" "+(name1.substring(8,10))+" "+(name1.substring(10); //academia de codigo
String name3 = name2.replaceFirst("a", "A"); //Academia de codigo





System.out.println("I am a Code Cadet at < "+name+"_ >, "+domain);



	}

}
