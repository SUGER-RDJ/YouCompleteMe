package BagPack.PRINT;

public class Text04 {
    //面向对象 封装 继承 多态 综合案例
    //一个students类，姓名，性别，年龄，学号
    //teachers类，姓名，性别，年龄，工龄
    //抽取一个父类Person类，将共同方法和属性放到Person类
    //学生有学习方法，教师有教学方法
    //学生和老师都有娱乐的方法，学生踢足球，老师下象棋
    //定义多态数组，里面保存两个学生和两个教师，按年龄从高到低排序
    //定义方法，形参为Person类型，调用学生或老师的方法

    public static void main(String[] args) {
        Student student = new Student("小明",'男',15,"0001234");
        student.printInfo();  //封装
        Teacher teacher = new Teacher("李亮",'女',36,10);
        teacher.printInfo();

        //定义多态数组，完成排序
        Person[] persons = new Person[4];
        persons[0] = new Student("jack",'男',11,"00013456");
        persons[1] = new Student("tom",'男',12,"00013457");
        persons[2] = new Teacher("marry",'女',33,10);
        persons[3] = new Teacher("Tracy",'女',45,20);

        Text04 text04 = new Text04();
        text04.bubbleSort(persons);
        for (int i=0;i< persons.length;i++){
            System.out.println(persons[i]);
        }
    }

    Person temp=null;
    public void bubbleSort(Person[] persons){
        for(int i = 0;i< persons.length-1;i++){
            for(int j =0;j< persons.length-1-i;j++){
                if (persons[j]!=null&&persons[j+1]!=null) {
                    if (persons[j].getAge() < persons[j + 1].getAge()) {
                        temp = persons[j];
                        persons[j] = persons[j + 1];
                        persons[j + 1] = temp;
                    }
                }
            }
        }
    }

}
