package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTestTest {
    @Test
    void subString() {
        String str = "test";
        assertEquals("es", str.substring(1, 3));
    }

}