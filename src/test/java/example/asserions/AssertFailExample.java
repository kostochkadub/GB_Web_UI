package example.asserions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertFailExample {

    @Test
    void myTest() {
        Assertions.fail("Я упал");
    }

}
