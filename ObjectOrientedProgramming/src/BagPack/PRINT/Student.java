package BagPack.PRINT;

public class Student extends Person{
    private String id;

    public Student(String name, char sex, int age, String id) {
        super(name, sex, age);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void study(){
        System.out.println("学生在学习");
    }

    @Override
    public String play() {
        return super.play() + "踢足球";
    }

    public void printInfo(){
        System.out.println("学生的信息");
        System.out.println(basicInfo());
        System.out.println("学号：" + id);
        study();
        System.out.println(play());

    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                '}' + super.toString();
    }
}
