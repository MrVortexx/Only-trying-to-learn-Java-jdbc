package jdbc.InvalidParamsException;

public class InvalidParamsException extends RuntimeException{
    
    public InvalidParamsException(String message, Throwable err){
        super(message, err);
    }
    public InvalidParamsException(String message){
        super(message);
    }
}