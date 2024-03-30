package Class_;

/**
 * 获取Class对象方式
 */
public class getClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

        //1.Class.forName
        String classAllPath = "Class_.Car";  //通常通过配置文件读取进来
        Class<?> cla1 = Class.forName(classAllPath);
        System.out.println(cla1);

        //2.类名.class
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3.Class cls = 对象.getClass();
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器（4种）获取到类的class对象
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);


    }
}
