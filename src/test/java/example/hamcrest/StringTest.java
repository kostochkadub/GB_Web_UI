package example.hamcrest;

import org.hamcrest.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    String name1 = "Ivan";
    String name2 = "IvAn";
    String name3 = "  Ivan  ";

    @Test
    void myTest() {
        Assertions.assertEquals(name1.toLowerCase(),name2.toLowerCase());
        Assertions.assertEquals(name1,name2);
    }


    @Test
    void equalToIgnoringCase() {
        MatcherAssert.assertThat(name1, Matchers.equalToIgnoringCase(name2));
    }


    @Test
    void equalToCompressingWhiteSpace() {
        MatcherAssert.assertThat(name3, Matchers.equalToIgnoringWhiteSpace(name1));
        //MatcherAssert.assertThat(name3, Matchers.equalToCompressingWhiteSpace(name1));
    }


    @Test
    void containsString() {

        MatcherAssert.assertThat(name1, Matchers.containsString("va"));
    }


    @Test
    void endsWith() {
        MatcherAssert.assertThat(name1, Matchers.endsWith("an"));
    }
}
