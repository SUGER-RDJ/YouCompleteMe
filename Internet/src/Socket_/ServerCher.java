package Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用字符流
 */
public class ServerCher {
    //服务器端（理论上服务器与客户端应在不同硬件设备上）
    public static void main(String[] args) throws IOException {
        //1.在本机的xxx端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(999);  //注意：要求在本机没有其他服务占用或监听999端口
        //2.当客户端没有连接xxx端口时，程序会阻塞，等待连接
        Socket socket = serverSocket.accept();  //如果有客户端连接则会返回socket对象，程序继续往下执行
        System.out.println("服务端socket返回："+socket.getClass());
        //3.通过socket.getInputStream()读取客户端写入的数据并显示
        InputStream inputStream = socket.getInputStream();

        //4.IO流读取，使用字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        //5.获取socket相关的输出流
        OutputStream outputStream = socket.getOutputStream();
        //使用字符输出流的方式回送信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");

    }
}
