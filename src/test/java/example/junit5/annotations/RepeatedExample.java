package example.junit5.annotations;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedExample {

    @RepeatedTest(50)
    void myTest() {
        assertEquals(2, 1 + 1);
    }
}
