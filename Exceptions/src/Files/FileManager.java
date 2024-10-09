package Files;

import Exceptions.FileException;
import Exceptions.FileNotFoundException;
import Exceptions.NotEnoughPermissionException;
import Exceptions.NotEnoughSpaceException;

public class FileManager {

    private boolean logged = false;
    private String[] filesName;
    private String[] usernames;
    private String[] passwords;
    private String name;
    private String password;
    private int userCounter = 0;

    public FileManager (){
        usernames = new String[10];
        passwords = new String[10];
        filesName = new String[10];
        name = new String();
        password = new String();


    }

    public void login(String username, String password){
        for (int i = 0; i < usernames.length; i++) {
            if(usernames[i] == this.name && passwords[i] == this.password){
                this.logged = true;
                System.out.println("Welcome " + this.name);
                return;
            } this.logged = false;
            System.out.println("Wrong password or username.");

            }

    }

    public void logout(String username, String password) throws  NotEnoughPermissionException{
        logged = false;
        if(logged = false){
            throw new NotEnoughPermissionException("No permission. Please log in");
        }
    }

    public File getFile(String name) throws FileNotFoundException, NotEnoughPermissionException{
        if(logged = false){
            throw new NotEnoughPermissionException("No permission. Please log in");
        }
        // deveria verificar se o nome do ficheiro existe e não se o array está vazio.
        File file = new File();
        name = file.getName();
        if (name == null){
            throw new FileNotFoundException("File not found");
        }
        return file;
    }

    public void createFile (String nameFile) throws NotEnoughSpaceException, NotEnoughPermissionException{
        if(logged = false){
            throw new NotEnoughPermissionException("No permission. Please log in");
        }

        File file = new File();
        for (int i = 0; i < filesName.length; i++) {
            filesName[i] = file.getName();
        }

        if (filesName[filesName.length-1] != null){
            throw new NotEnoughSpaceException("Not enough space");
        }

    }


    public void createUser(String name, String password){
        int i = this.userCounter;
        name= this.name;
        password = this.password;
        usernames[i] = name;
        passwords[i] = password;
        System.out.println("Your username: " + name);
        System.out.println("Your password: " + password);
        this.userCounter++;



    }

}
