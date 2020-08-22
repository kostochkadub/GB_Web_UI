package example.hamcrest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class AllOffTest {

    //Объединение проверок
    @Test
    void allOf() {
        double actual = 999.00;
        double expected = 99.00;

        MatcherAssert.assertThat(
                actual,
                Matchers.allOf(
                        Matchers.greaterThan(expected),
                        Matchers.lessThanOrEqualTo(1000.00),
                        Matchers.closeTo(expected, 1000.00) //с погрешностью
                )
        );
    }

    //Хотя бы одна проверка должны проходить
    @Test
    void anyOf() {
        double actual = 999.00;
        double expected = 99.00;

        MatcherAssert.assertThat(
                actual,
                Matchers.anyOf(
                        Matchers.greaterThan(expected),
                        Matchers.lessThanOrEqualTo(1.00),
                        Matchers.equalTo(expected)
                )
        );
    }

    @Test
    void equalTo() {
        double actual = 100.00;
        double expected = 90.00;

        MatcherAssert.assertThat(
                actual,
                Matchers.equalTo(expected)
        );
    }

    @Test
    void not() {
        double actual = 100.00;
        double expected = 90.00;

        MatcherAssert.assertThat(
                actual,
                Matchers.not(Matchers.equalTo(expected))
        );
    }
}
