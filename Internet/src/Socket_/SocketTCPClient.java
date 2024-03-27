package Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient {
    //客户端
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip，端口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 999); //连接InetAddress.getLocalHost()主机(即本机)的999端口,连接成功返回socket对象
        System.out.println("客户端socket返回："+socket.getClass());
        //2.连接上后，生成socket，通过
        OutputStream outputStream = socket.getOutputStream();  //得到和socket关联的输出流对象
        //socket.getOutputStream()读取
        //3.通过输出流，写入数据到数据通道
        outputStream.write("hello,server".getBytes());
        //设置一个写入结束标记
        socket.shutdownOutput();

        //4.获取和socket相关的输入流，读取数据（字节）并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readline = 0;
        while ((readline = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readline));
        }

        //5.关闭流对象和socket
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
