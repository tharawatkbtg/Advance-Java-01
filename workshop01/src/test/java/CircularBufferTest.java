import circularexception.EmptyBufferException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer();
    String msgErr = "Buffer is empty";
    @Test
    public void write_A_B_and_read_A_B_then_buffer_is_empty() throws EmptyBufferException {
        circularBuffer.create();
        circularBuffer.write("A");
        circularBuffer.write("B");
        circularBuffer.read();
        circularBuffer.read();
        assertTrue(circularBuffer.isEmpty());
    }

    @Test
    public void write_A_B_should_read_A_B() throws EmptyBufferException {
        circularBuffer.create();
        circularBuffer.write("A");
        circularBuffer.write("B");
        assertEquals("A", circularBuffer.read());
        assertEquals("B", circularBuffer.read());
    }

    @Test
    public void write_A_should_read_A() throws EmptyBufferException {
        circularBuffer.create();
        circularBuffer.write("A");
        String result = circularBuffer.read();
        assertEquals("A", result);
    }

    @Test
    public void write_A_read_A_and_write_B_read_B() throws EmptyBufferException {
        circularBuffer.create();
        circularBuffer.write("A");
        String result_a = circularBuffer.read();
        circularBuffer.write("B");
        String result_b = circularBuffer.read();
        assertEquals("A", result_a);
        assertEquals("B", result_b);
    }

//    @Test(expected = EmptyBufferException.class)
//    public void read_overflow() throws EmptyBufferException {
//        circularBuffer.create();
//        try {
//            String result = circularBuffer.read();
//        }catch (Exception e){
//            assertEquals(msgErr, circularException.getMessage());
//        }
//    }

    @Test
    public void read_overflowEmpty() throws EmptyBufferException {
        circularBuffer.create();
        Exception exception = assertThrows(EmptyBufferException.class,()->{
            circularBuffer.read();
        });
        assertNotNull(exception);
        assertEquals(msgErr, exception.getMessage());

    }

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้วเพิ่มข้อมูลเข้าไป ผลที่ได้ buffer ต้องไม่ว่าง")
    public void after_created_and_write_data_should_be_not_empty() {
        circularBuffer.create();
        circularBuffer.write("A");
        boolean status = circularBuffer.isEmpty();
        assertFalse(status);
    }

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้ว buffer จะต้องว่างเสมอ")
    public void after_created_should_be_empty() {
        circularBuffer.create();
        boolean status = circularBuffer.isEmpty();
        assertTrue(status);
    }

    @Test
    @DisplayName("ขนาดของ CircularBuffer ต้องมีขนาดเท่ากับ 5")
    public void create_buffer_with_specified_size_5() {
        // Act
        circularBuffer.create(5);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(5, size);
    }

    @Test
    @DisplayName("ขนาด default ของ CircularBuffer ต้องมีขนาดเท่ากับ 10")
    public void create_buffer_with_default_size() {
        // Act
        circularBuffer.create();
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(10, size);
    }

}