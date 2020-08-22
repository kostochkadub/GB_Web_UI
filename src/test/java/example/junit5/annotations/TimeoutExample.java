package example.junit5.annotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeoutExample {

    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @Test
    void myTest() throws InterruptedException {
        sleep(3000);
    }
}
