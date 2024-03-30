package Class_;

import java.util.Scanner;
import java.lang.reflect.*;

public class ClassLoad {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key");
        String key = scanner.next();
        switch (key){
            case "1":
                //静态加载：找不到类就会报错，依赖性过高
//                Dog dog = new Dog();
//                dog.cry();
                Car car = new Car();
                car.toString();
                break;
            case "2":
                //反射——》动态加载：降低了依赖性
                Class cls = Class.forName("Person");
                Object o = cls.newInstance();
                Method method = cls.getMethod("hi");
                method.invoke(o);
                System.out.println("ok");
                break;
            default:
                System.out.println("do nothing...");
        }
    }
}
