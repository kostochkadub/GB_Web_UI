package example.junit5.annotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedExample {

    @Test
    void myTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void myTest1() {
        assertEquals(3, 1 + 2);
    }

    @Test
    void myTest2() {
        assertEquals(3, 2 + 1);
    }

    @Test
    void myTest3() {
        assertEquals(6, 3 + 3);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void checkSum(int expected, int actual) {
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(2,2),
                Arguments.of(5,2),
                Arguments.of(5,5),
                Arguments.of(3,2),
                Arguments.of(3,1)
        );
    }
}
