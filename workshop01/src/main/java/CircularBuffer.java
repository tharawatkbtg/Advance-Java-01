import java.util.Arrays;

public class CircularBuffer {

    private String[] buffers;

    // TODO
    public void create(){// default size = 10
        buffers = new String[10];
    }

    public void create(int size) {
        buffers = new String[size];
    }
    public void write(String input){

    }

    public String read(){
        String result = "";
        return result;
    }

    public int getSize(){
        int result = 0;
        result = buffers.length;
        return result;
    }

    public boolean isEmpty(){
        boolean result = false;
        return result;
    }

    public boolean isFull(){
        boolean result = false;
        return result;
    }
}
