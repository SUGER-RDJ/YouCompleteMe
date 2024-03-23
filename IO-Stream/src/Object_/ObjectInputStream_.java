package Object_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 读写顺序需一致
 * 要求序列化和反序列化对象实现Serializable
 *序列化的对象中建议添加SerialVersionUID，提高版本兼容性
 * 序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
 * 序列化对象时，要求里面属性的类型也需要实现序列化接口
 * 序列化具备可继承性，也就是如果某类已经实现了序列化，则他的所有子类已经默认实现了序列化
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception{
        String filePath = "src/Object_/OUTPUT.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        //读取(反序列化)顺序需要和保存数据（序列化数据）的顺序一致，否则报错
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println(dog);

        //如果希望调用Dog的方法，需要向下转型
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName());

        ois.close();
    }
}