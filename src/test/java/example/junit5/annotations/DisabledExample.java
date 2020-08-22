package example.junit5.annotations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisabledExample {

    @Test
    void myTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void myTest1() {
        assertEquals(2, 1 + 1);
    }

    @Disabled
    @Test
    void myTest2() {
        assertEquals(2, 1 + 1);
    }
}
