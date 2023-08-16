package Library.Exception;

public class EmptyRequestException extends RuntimeException{
    public EmptyRequestException(String message){
        super(message);
    }
}
