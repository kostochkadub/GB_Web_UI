package example.collections.list;

import example.equals.and.hashcode.Dog;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample2 {

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        Dog bubbles = new Dog("Шарик");
        Dog bobik = new Dog("Бобик");

        Dog matros = new Dog("Матрос");

        Dog matros2 = new Dog("Матрос");

        //Добавление элементов
        list.add(bubbles);
        list.add(bobik);
        list.add(matros);

        System.out.println(list.contains(matros2));

    }



}
