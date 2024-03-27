package API;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 演示InetAddress类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //根据主机名获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("zhaoheqiandeMacBook-Pro.local");
        System.out.println(host1);
        //根据域名返回InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
        //通过InetAddress对象获取对应地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress);
        //通过InetAddress对象获取对应主机名/域名
        String hostName = host2.getHostName();
        System.out.println(hostName);

    }
}
