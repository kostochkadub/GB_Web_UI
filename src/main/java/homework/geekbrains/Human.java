package homework.geekbrains;

public class Human {
    protected String name;
    protected double maxRun;
    protected double maxJump;

    public Human(String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public void jump(double length) {
        if (length <= maxJump) {
            System.out.println("Human " + name + " перепрыгул " + length + " м");
        } else System.out.println("Human " + name + " не может прыгнуть на " + length + " м");
    }

    public void run(double length) {
        if (length <= this.maxRun) {
            System.out.println("Human " + name + " бежит " + length + " м");
        } else System.out.println("Human " + name + " не может так бегать на " + length + " м");
    }
}
