package example.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeworkTaskOne {
    public static void main(String[] args) {

        // Создать коллекцию с набором из 10–20 слов, должны встречаться повторяющиеся.
        // Найти и вывести список уникальных слов, из которых состоит коллекция.
        // Посчитать, сколько раз встречается каждое слово.

        Map<String, Integer> states_map = new HashMap<String, Integer>();

        ArrayList<String> states = new ArrayList<String>();
        states.add("Норвегия");
        states.add("Япония");
        states.add("Китай");
        states.add("Франция");
        states.add("Япония");
        states.add("Япония");
        states.add("Китай");
        states.add("Япония");
        states.add("Китай");
        states.add("Китай");
        states.add("Великобривания");
        states.add("Китай");
        states.add("Китай");
        states.add("Китай");
        states.add("Франция");

        for (int i = 0; i < states.size(); i++) {
            String tempVar = states.get(i);
            if (!states_map.containsKey(tempVar)) {
                states_map.put(tempVar, 1);
            } else {
                states_map.put(tempVar, states_map.get(tempVar) + 1);
            }

        }

        //вывести список уникальных слов
        for (Map.Entry<String, Integer> item : states_map.entrySet()) {
            if (item.getValue() == 1) {
                System.out.printf("Уникальное слово: %s  \n", item.getKey());
            }
        }
        // Перебор элементов
        for (Map.Entry<String, Integer> item : states_map.entrySet()) {
            System.out.printf("Слово: %s  Повторяетя: %d \n", item.getKey(), item.getValue());
        }


    }
}

