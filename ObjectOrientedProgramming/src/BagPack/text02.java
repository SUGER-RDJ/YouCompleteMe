package BagPack;

public class text02 {
    //编写教师类：名字，年龄，职称，基本工资
    //编写业务方法，introduce()实现输出一个教师的信息
    //编写教师的三个子类：教授类，副教授类，讲师类工资级别分别为1.3，1.2，1.1三个子类都重写introduce方法
    //定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印
    public static void main(String[] args) {
        Professor professor = new Professor("王教授", 40, "高级职称", 30000, 1.3);
        professor.introduce();
        //副教授讲师同理
        AsProfessor asProfessor = new AsProfessor("李副教授", 35, "中级职称", 25000, 1.2);
        asProfessor.introduce();
        Lecturer lecturer = new Lecturer("张讲师", 30, "中级职称", 25000, 1.1);
        lecturer.introduce();
    }
}
