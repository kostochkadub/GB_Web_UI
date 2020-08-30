package example.collections.list;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;

public class ArrayListExample {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        Assertions.assertTrue(collection.isEmpty());


//Добавление элементов
        collection.add("Лорд");
        collection.add("Шарик");
        collection.add("Тузик");
        collection.add("Бублик");
        collection.add("Бублик");


//Пример итератора
        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();

            if(next.equals("Лорд")){
                break;
            }
        }
        System.out.println(iterator.next());



        Assertions.assertFalse(collection.isEmpty());
//количество элементов
        Assertions.assertEquals(5, collection.size());





//Удаление объектов
        Assertions.assertTrue(collection.remove("Тузик"));
//Проверки на вхождение
        Assertions.assertFalse(collection.contains("Тузик"));


//        Удаление объектов всех
        collection.clear();
        Assertions.assertTrue(collection.isEmpty());



    }



}
