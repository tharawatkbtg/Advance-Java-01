package circularexception;

public class EmptyBufferException extends RuntimeException{
    public EmptyBufferException(){
        super("Buffer is empty");
    }
}
