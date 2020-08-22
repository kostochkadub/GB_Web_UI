package example.asserions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class AssertionsAllExample {

    @Test
    void myTest() {
        Assertions.assertAll("user",
                ()->Assertions.assertEquals("Ivan","Petr"),
                ()->Assertions.assertEquals("Ivan","Ivan"),
                ()->Assertions.assertEquals("Ivan1","Petr"),
                ()->Assertions.assertEquals("Petr","Petr"));

    }
}
