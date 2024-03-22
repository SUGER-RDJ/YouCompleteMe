package BagPack.PRINT;

public class Teacher extends Person{
    private int workage;

    public Teacher(String name, char sex, int age, int workage) {
        super(name, sex, age);
        this.workage = workage;
    }

    public int getWorkage() {
        return workage;
    }

    public void setWorkage(int workage) {
        this.workage = workage;
    }

    public void teach(){
        System.out.println("老师在授课");
    }

    @Override
    public String play() {
        return super.play() + "下象棋";
    }

    public void printInfo(){
        System.out.println("老师的信息");
        System.out.println(basicInfo());
        System.out.println("工龄：" + workage);
        teach();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "workage=" + workage +
                '}' + super.toString();
    }
}
