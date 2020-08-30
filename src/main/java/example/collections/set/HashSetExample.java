package example.collections.set;

import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {
        Collection<String> collection = new HashSet<>();
        Assertions.assertTrue(collection.isEmpty());


//Добавление элементов
        collection.add("Лорд");
        collection.add("Шарик");
        collection.add("Тузик");
        collection.add("Бублик");
        collection.add("Бублик");

        Assertions.assertFalse(collection.isEmpty());
//количество элементов
        //Обратите Внимание! что объектов 4 а не 5
        Assertions.assertEquals(4, collection.size());

//Удаление объектов
        Assertions.assertTrue(collection.remove("Тузик"));
//Проверки на вхождение
        Assertions.assertFalse(collection.contains("Тузик"));

        //Удаление объектов всех
        collection.clear();
        Assertions.assertTrue(collection.isEmpty());


    }
}
