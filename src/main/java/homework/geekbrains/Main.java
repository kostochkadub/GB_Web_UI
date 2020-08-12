package homework.geekbrains;

public class Main {
    public static void main(String[] args) {

        Wall[] wall = new Wall[2];
        wall[0] = new Wall(21);
        wall[1] = new Wall(10);

        Treadmill[] treadmill = new Treadmill[3];
        treadmill[0] = new Treadmill(5);
        treadmill[1] = new Treadmill(10);
        treadmill[2] = new Treadmill(15);

        Cat[] cat = new Cat[6];

        cat[0] = new Cat("Holly", 2, 2);
        cat[1] = new Cat("Molly", 5, 3);
        cat[2] = new Cat("Lily", 8, 4);
        cat[3] = new Cat("Barsik", 20, 6);
        cat[4] = new Cat("Unio", 7, 12);
        cat[5] = new Cat("UnioTest", 7, 21);

        Robot[] robot = new Robot[5];

        robot[0] = new Robot("D1", 7, 25);
        robot[1] = new Robot("D2", 20, 4);
        robot[2] = new Robot("D3", 5, 12);
        robot[3] = new Robot("R2D2", 1, 25);
        robot[4] = new Robot("R2D3", 10, 50);

        Human[] human = new Human[5];

        human[0] = new Human("Boris", 7, 4);
        human[1] = new Human("Pasha", 14, 4);
        human[2] = new Human("Sveta", 13, 12);
        human[3] = new Human("Kostya", 9, 15);
        human[4] = new Human("Dasha", 20, 10);


//Прыжки в высоту
        funkJump(cat, robot, human, wall);
//Бег
        funkRun(cat, robot, human, treadmill);

    }

    public static void funkJump(Cat[] catArray, Robot[] robotArray, Human[] humanArray, Wall[] wallArray) {
        for (int i = 0; i < wallArray.length; i++) {
            //кошки
            for (int c = 0; c < catArray.length; c++) {
                catArray[c].jump(wallArray[i].getHeight());
            }
            //роботы
            for (int r = 0; r < robotArray.length; r++) {
                robotArray[r].jump(wallArray[i].getHeight());
            }
            //люди
            for (int h = 0; h < humanArray.length; h++) {
                humanArray[h].jump(wallArray[i].getHeight());
            }
        }
    }

    public static void funkRun(Cat[] catArray, Robot[] robotArray, Human[] humanArray, Treadmill[] treadmillArray) {
        for (int i = 0; i < treadmillArray.length; i++) {
            //кошки
            for (int c = 0; c < catArray.length; c++) {
                catArray[c].jump(treadmillArray[i].getLength());
            }
            //роботы
            for (int r = 0; r < robotArray.length; r++) {
                robotArray[r].jump(treadmillArray[i].getLength());
            }
            //люди
            for (int h = 0; h < humanArray.length; h++) {
                humanArray[h].jump(treadmillArray[i].getLength());
            }
        }
    }
}
