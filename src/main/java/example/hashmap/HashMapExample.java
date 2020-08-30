package example.hashmap;

import example.equals.and.hashcode.Dog;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Dog bubbles = new Dog("Шарик");
        Dog bobik = new Dog("Бобик");
        Dog matros = new Dog("Матрос");

        String ivan = "Иван";
        String petr = "Петр";
        String ira = "Ирина";
        String vitalyi = "Виталий";


        HashMap<String, Dog> stringDogHashMap = new HashMap<>();

        stringDogHashMap.put(ivan,bubbles);
        stringDogHashMap.put(petr,matros);
        stringDogHashMap.put(petr,bobik);


        System.out.println(stringDogHashMap);

        stringDogHashMap.clear();


        stringDogHashMap.put(ivan,bubbles);
        stringDogHashMap.put(petr,matros);
        stringDogHashMap.put(ira,bobik);
        stringDogHashMap.put(vitalyi,bobik);

        System.out.println(stringDogHashMap);


        Set<String> strings = stringDogHashMap.keySet();

        Collection<Dog> values = stringDogHashMap.values();

        //Проверка на вхождение

        Assertions.assertTrue(stringDogHashMap.containsKey(vitalyi));
        Assertions.assertTrue(stringDogHashMap.containsValue(matros));


    }

}
