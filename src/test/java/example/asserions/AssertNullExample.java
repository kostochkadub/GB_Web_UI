package example.asserions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertNullExample {

    @Test
    void myTest() {
        String name = "Dog";

        Assertions.assertNotNull(name);

    }

    @Test
    void myTest2() {
        String name = null;

        Assertions.assertNotNull(name);

    }
}
