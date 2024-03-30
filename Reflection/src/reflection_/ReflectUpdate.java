package reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射调用优化：关闭访问检查
 * Method和Filed、Constructor对象都有setAccessible方法
 * 参数设置为true表示反射的对象在使用时取消访问检查，提高反射的效率。参数值为false则表示反射的对象执行访问检查
 * forName方法调用的是类路径，而不是相对路径！！
 */
public class ReflectUpdate {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        m1();
        m2();
        m3();
    }

    //传统方法调用hi
    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();//获取运行时间(毫秒)
        for (int i = 0;i < 10000;i++){
            cat.hi();
        }
        long end = System.currentTimeMillis();//获取结束时间(毫秒)
        System.out.println("传统方法调用耗时："+(end-start));
    }

    // 反射机制调用hi
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("reflection_.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");

        long start = System.currentTimeMillis();//获取运行时间(毫秒)
        for (int i = 0;i < 10000;i++){
            method.invoke(o);
        }
        long end = System.currentTimeMillis();//获取结束时间(毫秒)
        System.out.println("反射机制调用耗时："+(end-start));
    }

    //反射调用优化+关闭访问检查
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("reflection_.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");
        method.setAccessible(true);

        long start = System.currentTimeMillis();//获取运行时间(毫秒)
        for (int i = 0;i < 10000;i++){
            method.invoke(o);
        }
        long end = System.currentTimeMillis();//获取结束时间(毫秒)
        System.out.println("反射机制优化后调用耗时："+(end-start));
    }
}

