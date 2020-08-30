package example.arraylist;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();


//Добавление элементов
        list.add("Лорд");
        list.add("Шарик");
        list.add("Тузик");
        list.add("Бублик");
        list.add("Бублик");

        System.out.println(list);

        list.add(0,"Споук");

        System.out.println(list);

        //Получение элемента
        Assertions.assertEquals(list.get(0),"Споук");


        //Удаление элемента
        list.remove(0);
        list.remove("Лорд");

        System.out.println(list);

        //Получение элемента
        Assertions.assertEquals(list.get(0),"Шарик");

        System.out.println(list);

        //Замена элемента
        list.set(0,"Мопсик");
        Assertions.assertEquals(list.get(0),"Мопсик");
        Assertions.assertEquals(list.get(1),"Тузик");
    }
}
