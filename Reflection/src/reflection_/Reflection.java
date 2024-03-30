package reflection_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射机制
 * java.lang.Class：代表一个类，Class对象表示某个类加载后在堆中的对象
 * java.lang.reflect.Method:代表类的方法，Method对象表示某个类的方法
 * java.lang.reflect.Field:代表类的成员变量，Field对象表示某个类的成员变量
 * java.lang.reflect.Constuctor:代表类的构造方法，Constructor对象表示构造器
 */
@SuppressWarnings({"all"})
public class Reflection {
    public static void main(String[] args) throws Exception {

        //使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/reflection_/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();


        //使用反射机制解决
        //1.加载类，返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls得到你加载的类的对象实例
        Object o = (Cat)cls.newInstance();
        //3.通过cls得到加载的类reflection_.Cat的methodName的方法对象
        //即在反射机制中，可以将方法视为对象
        Method method = cls.getMethod(methodName);
        //4.通过method调用方法，即通过方法对象调用方法
        method.invoke(o);  //注意：通过反射调用方法，方法需要是公共的
        //5.得到age字段,此方法同样无法得到私有属性
        Field age = cls.getField("age");
        System.out.println(age.get(o));
        //()中可以指定构造器参数类型，若无指定则返回无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        Constructor constructor2 = cls.getConstructor(String.class);//这里传入String类型的Class对象
        System.out.println(constructor2);

    }
}
