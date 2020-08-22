package example.asserions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsExample {

    @Test
    void myTest() {
        assertEquals(3, 2 + 1);
        assertEquals("3", "3");

        Object o1 = new Object();
        Object o2 = o1;
        assertEquals(o1, o2);

    }

}
