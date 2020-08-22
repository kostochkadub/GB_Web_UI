package example.junit5.annotations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Супер тест набор")
public class DisplayNameExample {

    @DisplayName("Супер тест1")
    @Test
    void myTest1() {
        assertEquals(2, 1 + 1);
        System.out.println("myTest1");
    }

}

