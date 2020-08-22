package example.asserions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertTruesExample {

    @Test
    void myTest() {
        Assertions.assertTrue(2 == 3, "Чила не равны!");

    }

}
