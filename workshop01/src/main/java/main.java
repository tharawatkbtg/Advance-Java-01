public class main {
    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer();
        // Create buffer : default size = 10
        circularBuffer.create();
        // Size of buffer
        int size = circularBuffer.getSize();
        System.out.println(size);
    }
}
