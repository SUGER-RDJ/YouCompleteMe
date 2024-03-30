package reflection_.ReflecAccess;

import java.lang.reflect.Field;

/**
 * 演示反射操作属性
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //1.得到Students类对应的Class对象
        Class<?> stuClass = Class.forName("reflection_.ReflecAccess.Students");
        //2.创建对象
        Object o = stuClass.newInstance();
        System.out.println(o.getClass());
        //3.使用反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o,88); //通过反射来设置属性
        System.out.println(o);
        //4.使用反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);  //爆破后操作私有属性
        name.set(o,"tom");
        System.out.println(o);

    }
}

class Students{
    public int age;
    private static String name;
    public Students(){}

    @Override
    public String toString() {
        return "Students{" +
                "age=" + age +
                "name=" + name +
                '}';
    }
}