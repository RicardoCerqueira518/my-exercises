package Exceptions;

public class NotEnoughPermissionException extends FileException {


    public NotEnoughPermissionException(String message) {
        super(message);
    }
}
