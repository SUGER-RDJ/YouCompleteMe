package Class_;

import java.lang.reflect.Field;

/**
 * Class类特点梳理
 * 1.Class也是类，因此继承了Object类
 * 2.Class类对象不是new出来的，而是系统创建的
 * 3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
 * 4.每个类的实例都会记得自己由哪个Class实例所生成
 * 5.通过Class可以完整的得到一个类的完整结构，通过一系列API
 * 6.Class对象是存放在堆中的
 * 7.类的字节码二进制数据是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等）
 */
public class class_ {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //演示Class类的常用方法
        String classAllPath = "Class_.car";

        //获取Class类对应的Class对象
        //<?>表示不确定的Java类型，throws ClassNotFoundException表示如果你加载了不存在的类，便会报出异常
        Class<?> cls = Class.forName(classAllPath);

        //输出cls
        System.out.println(cls);  //直接输出会显示cls对象是那个Class类的对象
        System.out.println(cls.getClass());  //输出运行类型

        //得到包名
        System.out.println(cls.getPackage().getName());

        //得到全类名
        System.out.println(cls.getName());

        //通过cls创建对象实例
        Object o = cls.newInstance();
        System.out.println(o); //调用同String方法

        //通过反射获取属性
        Field brand = cls.getField("brand");  //只能获取公有属性，私有属性通过方法间接获取
        System.out.println(brand.get(o));

        //通过反射给属性赋值
        brand.set(o,"TOYOTA");
        System.out.println(brand.get(o));

        //遍历所有属性（字段）
        Field[] fields = cls.getFields();
        for (Field f : fields){
            System.out.print(f.getName()+" ");
        }

    }
}
