package homeWork1;

public class Robot {

    protected String name;
    protected double maxRun;
    protected double maxJump;

    public Robot(String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public void jump(double length) {
        if(length <= maxJump){
            System.out.println("Robot "+name+" перепрыгул "+length+" м");
        }else System.out.println("Robot " + name + " не может прыгнуть на " + length + " м");
    }

    public void run(double length) {
        if(length <= this.maxRun){
            System.out.println("Robot "+name+" бежит "+length+" м");
        }
        else System.out.println("Robot "+name+" не может так бегать на "+length+" м");
    }
}
