package example.collections.set;

import example.equals.and.hashcode.Dog;

import java.util.HashSet;
import java.util.Set;

public class SetExample2 {

    public static void main(String[] args) {
        Set<Dog> set = new HashSet<>();
        Dog bubbles = new Dog("Шарик");
        Dog bobik = new Dog("Бобик");
        Dog matros = new Dog("Матрос");
        Dog matros2 = new Dog("Матрос");


        //Добавление элементов
        set.add(bubbles);
        set.add(bobik);
        set.add(matros);
        set.add(matros2);

        System.out.println(set);
    }



}
