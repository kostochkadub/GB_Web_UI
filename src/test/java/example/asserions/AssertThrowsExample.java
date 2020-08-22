package example.asserions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssertThrowsExample {

    @Test
    void myTest() throws FileNotFoundException {
        File file = new File("src/test/resources/testFileLesson4");

        Assertions.assertThrows(FileNotFoundException.class, ()->new Scanner(file));;

    }

}
