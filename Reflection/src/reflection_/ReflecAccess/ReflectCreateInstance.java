package reflection_.ReflecAccess;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射机制创建实例
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //1.先获取到User类的Class对象
        Class<?> userClass = Class.forName("reflection_.ReflecAccess.User");

        //2.通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        //3.通过public的有参构造器创建实例
        Constructor<?> constructor = userClass.getConstructor(String.class);  //此时constructor对象就是public有参构造器
        Object o1 = constructor.newInstance("Tom");
        System.out.println(o1);

        //4.通过非public的有参构造器创建实例
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);  //爆破，使用反射可以访问私有构造器
        Object o2 = declaredConstructor.newInstance(10, "cat");
        System.out.println(o2);
    }
}

class User{
    private int age;
    private String name;

    public User(){}
    public User(String name){
        this.name = name;
    }
    private User(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
