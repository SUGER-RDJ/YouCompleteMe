package Object_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化：在保存数据时保存值和数据类型
 * 反序列化：将保存在文件的数据（值和数据类型）重新恢复成对象
 * ObjectOutputStream提供序列化功能
 * ObjectInputStream提供反序列化功能
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception{
        //序列化后，保存的文件格式不是纯文本的，而是按照规定格式保存
        String filepath = "src/Object_/OUTPUT.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeInt(100); //int自动装箱为Integer（实现了Serializable）
        oos.writeBoolean(true); //Boolean
        oos.writeChar('a');  //Charactor
        oos.writeDouble(9.5);  //Double
        oos.writeUTF("史猪猪就会睡觉"); //String使用UTF保存
        oos.writeObject(new Dog("小黄",10)); //保存一个Dog对象

        oos.close();
        System.out.println("数据保存完毕（序列化形式）");
    }
}

//如果需要序列化某个类的对象，必须实现Serializable
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}