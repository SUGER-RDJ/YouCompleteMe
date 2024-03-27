package Socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientChar {
    //客户端
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip，端口）
        Socket socket = new Socket(InetAddress.getLocalHost(), 999); //连接InetAddress.getLocalHost()主机(即本机)的999端口,连接成功返回socket对象
        System.out.println("客户端socket返回："+socket.getClass());
        //2.连接上后，生成socket，通过
        OutputStream outputStream = socket.getOutputStream();  //得到和socket关联的输出流对象
        //socket.getOutputStream()读取
        //3.通过输出流，写入数据到数据通道， 要求使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server字符流");
        bufferedWriter.newLine();  //插入一个换行符，表示写入结束，要求对方使用readLine读数据
        bufferedWriter.flush(); //如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

        //4.获取和socket相关的输入流，读取数据（字符）并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //5.关闭流对象和socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
