package example.equals.and.hashcode;

import java.util.Objects;

public class Dog {
    public String name;
    public String breed;
    public int age;
    public int weight;

    public int dogPassportNumber;

    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age &&
                weight == dog.weight &&
                dogPassportNumber == dog.dogPassportNumber &&
                Objects.equals(name, dog.name) &&
                Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, age, weight, dogPassportNumber);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", dogPassportNumber=" + dogPassportNumber +
                '}';
    }
}

