package properties_;

import java.io.*;
import java.util.Properties;

/**
 * 将需求写入到properties配置文件，方便读取或写入
 * 专门用于读写配置文件的集合类
 * 配置文件形式：键=值，键值对不需要有空格，值不需要用引号，默认类型是String
 *Propertise常见方法：
 * load：加载配置文件的键值对到Propertis对象
 * list：将数据显示到指定设备
 * getProperty(key)：根据键获取值
 * setProperty(value)：设置键值对到Properties对象
 * store：将Properties中的键值对存储到配置文件，在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码
 */
public class Propertise_ {
    public static void main(String[] args) throws IOException {

        //读取配置文件，并获取相应信息
        BufferedReader bd = new BufferedReader(new FileReader("src/mysql.properties"));
        String line = null;
        while ((line = bd.readLine()) != null){
            String[] split = line.split("=");
            System.out.println(split[0] + split[1]);

        }
        bd.close();

        //演示使用Properties类来读取mysql.properties文件
        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        properties.list(System.out);
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名："+user);
        System.out.println("密码："+pwd);


        //使用Properties类来创建配置文件，修改配置文件内容
        //如果该文件没有key就是创建，如果有则为修改
        Properties properties2 = new Properties();
        properties2.setProperty("charset","utf-8");
        properties2.setProperty("user","tom");
        properties2.setProperty("pwd","111111");
        properties2.store(new FileOutputStream("src/mysql2.properties"),null);
        System.out.println("保存配置文件成功");

    }
}
