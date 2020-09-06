package homework7.task2;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    HashMap<String, ArrayList<Integer>> phonebook;

    Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String secondName, int phoneNumbers) {
        ArrayList<Integer> tempVar = phonebook.getOrDefault(secondName, new ArrayList<>());//getOrDefault - если не существует
        tempVar.add(phoneNumbers);
        phonebook.put(secondName, tempVar);
    }

    public void get(String secondName) {
        System.out.println("Контакты " + secondName + ": " + phonebook.getOrDefault(secondName, new ArrayList<>()));
    }
}
