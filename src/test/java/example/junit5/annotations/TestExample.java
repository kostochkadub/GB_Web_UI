package example.junit5.annotations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExample {

    @Test
    void myTest(){
        assertEquals(2,1+1);
    }
}
