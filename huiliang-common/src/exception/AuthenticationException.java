package exception;

public class AuthenticationException extends Exception {
    public AuthenticationException(String msg){
        super(msg);
    }
    public AuthenticationException(){
        super();
    }
}
