package example.junit5.annotations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeAndAfterExample {


    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void setup() {
        System.out.println("beforeEach");
    }

    @Test
    void myTest1() {
        assertEquals(2, 1 + 1);
        System.out.println("myTest1");
    }

    @Test
    void myTest2() {
        assertEquals(2, 1 + 1);
        System.out.println("myTest2");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }
}
