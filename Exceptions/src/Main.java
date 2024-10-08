import Exceptions.FileNotFoundException;
import Exceptions.NotEnoughPermissionException;
import Exceptions.NotEnoughSpaceException;
import Files.FileManager;

public class Main {

    public static void main(String[] args) {

        FileManager filesmanager = new FileManager();

        filesmanager.createUser("Ricardo", "Xico69");
        filesmanager.createUser("Diogo", "Dioguinho99");


        try {
            filesmanager.createFile("file");
            filesmanager.getFile("file");
            filesmanager.logout("name", "password");


        } catch (NotEnoughSpaceException e) {
            System.out.println("Not enough space");
        } catch (NotEnoughPermissionException e) {
            System.out.println("No permission. Please log in");
        } catch (FileNotFoundException e) {
            System.out.println("Name not found");
        }


    }

}
