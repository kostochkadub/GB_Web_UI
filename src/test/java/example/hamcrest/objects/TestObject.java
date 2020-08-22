package example.hamcrest.objects;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class TestObject {

    @Test
    void sameInstance() {
        Dog mike = new Dog("Mike");
        Dog mikeLink = mike;

        MatcherAssert.assertThat(mike, Matchers.sameInstance(mikeLink));
    }


    @Test
    void hasToString() {
        Dog mike = new Dog("Mike");
        System.out.println(mike.toString());
        MatcherAssert.assertThat(mike, Matchers.hasToString("Dog{name='Mike'}"));
    }

    @Test
    void typeCompatibleWith() {
        MatcherAssert.assertThat(Dog.class, Matchers.typeCompatibleWith(Animals.class));
    }

    @Test
    void instanceOf() {
        Dog mike = new Dog("Mike");;
        MatcherAssert.assertThat(mike, Matchers.instanceOf(Animals.class));
    }

    @Test
    void hasProperty() {
        Dog mike = new Dog("Mike");
        MatcherAssert.assertThat(mike, Matchers.hasProperty("name", Matchers.equalTo("Mike")));
    }

    @Test
    void samePropertyValuesAs() {
        Dog mike1 = new Dog("Mike");
        Dog mike2 = new Dog("Mike");

//        MatcherAssert.assertThat(spoke1,  Matchers.equalTo(spoke2));
        MatcherAssert.assertThat(mike1, Matchers.samePropertyValuesAs(mike2));
    }
}
