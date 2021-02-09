package circularexception;

public class NullBufferException extends RuntimeException{
    public NullBufferException(){
        super("Buffer is not create");
    }
}
