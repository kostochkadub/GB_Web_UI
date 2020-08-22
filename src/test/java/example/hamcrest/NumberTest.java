package example.hamcrest;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    void myTest() {
        int actual = 100;
        int expected = 110;

        MatcherAssert.assertThat(actual, Matchers.greaterThan(expected));

        //Проверка с погрешностью
        MatcherAssert.assertThat(301.00, Matchers.closeTo(300, 1));
    }
}
