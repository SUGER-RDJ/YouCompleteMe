package reflection_;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        ReflectionUtils.api_01();
        ReflectionUtils.api_02();
    }
    public static void api_01() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> personClass = Class.forName("reflection_.Person");

        //获取全类名
        System.out.println(personClass.getName());
        //获取简单类名
        System.out.println(personClass.getSimpleName());
        //获取所有public修饰的属性，包含本类以及其父类
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类所有属性"+field.getName());
        }
        //获取本类中所有属性
        Field[] declaredField = personClass.getDeclaredFields();
        for (Field field : declaredField) {
            System.out.println("本类中所有属性"+field);
        }
        //获取所有public修饰的方法，包含本类及其父类
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的方法："+method.getName());
        }
        //获取本类中所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法："+declaredMethod.getName());
        }
        //获取所有public修饰的构造器，只包含本类
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类所有public修饰的构造器："+constructor);
        }
        //获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器"+declaredConstructor);
        }
        //以Package形式返回包信息
        System.out.println(personClass.getPackage());
        //以Class形式返回父类信息
        Class<?> superclass = personClass.getSuperclass();
        System.out.println("父类class对象："+superclass);
        //以Class[]形式返回接口信息
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息"+anInterface);
        }
        //以Annotation形式返回注解信息
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息"+annotation);
        }
    }

    public static void api_02() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("reflection_.Person");
        //以int形式返回修饰符（默认修饰符是0，public是1，private是2，protected是4，static是8，fianal是16，）public+static=9
        //以Class形式返回类型
        //返回属性名
        Field[] declaredField = personClass.getDeclaredFields();
        for (Field field : declaredField) {
            System.out.println("本类中所有属性"+field.getName()
                    +"该属性的修饰符值：" +field.getModifiers()
                    + "该属性的类型"+field.getType()
                    );
        }

    }
}


class Father{
    public String hobby;
    public void hi(){}

    public Father() {}
}
interface IA{}
interface IB{}
class Person extends Father implements IA,IB{
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person(){}
    public Person(String name){}
    private Person(int age){}

    public void m1(){}
    protected void m2(){}
    void m3(){}
    private void m4(){}

}