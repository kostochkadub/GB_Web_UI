package example.equals.and.hashcode;

public class Start {

    public static void main(String[] args) {

        Dog dog1 = new Dog();
        dog1.dogPassportNumber=123456;
        System.out.println(dog1.hashCode());
        dog1.dogPassportNumber=1234568;
        System.out.println(dog1.hashCode());
//        Dog dog2 = new Dog();
//        dog2.dogPassportNumber=123456;


//        System.out.println(dog1.hashCode());
//        System.out.println(dog2.hashCode());
    }
}
