package homework7.task2;

public class Main {

    //Написать простой класс Телефонный Справочник, который хранит список фамилий и телефонных номеров.
    //В него с помощью метода add() можно добавлять записи, а с помощью get() — искать номер телефона по фамилии.
    // Для одной фамилии может быть несколько телефонов (однофамильцы): тогда при запросе такой фамилии должны выводиться все номера.
    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.add("Норвегия", 123);
        phonebook.add("Норвегия", 2123);
        phonebook.add("Норвегия", 323);

        phonebook.add("Германия", 16785);
        phonebook.add("Германия", 26785);
        phonebook.add("Германия", 36785);
        phonebook.add("Германия", 46785);


        phonebook.get("Норвегия");
        phonebook.get("Германия");
    }
}
