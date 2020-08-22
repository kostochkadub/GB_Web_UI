package example.asserions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class AssertionsArrayExample {

    @Test
    void myTest() {
        String[] strings1={"321","321"};
        String[] strings2={"321","321"};

        assertArrayEquals(strings1, strings2);

    }
}
