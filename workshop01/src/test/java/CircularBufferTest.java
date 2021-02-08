import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer();

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