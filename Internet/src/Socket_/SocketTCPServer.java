package Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
    //服务器端（理论上服务器与客户端应在不同硬件设备上）
    public static void main(String[] args) throws IOException {
        //1.在本机的xxx端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(999);  //注意：要求在本机没有其他服务占用或监听999端口
        //2.当客户端没有连接xxx端口时，程序会阻塞，等待连接
        Socket socket = serverSocket.accept();  //如果有客户端连接则会返回socket对象，程序继续往下执行
        System.out.println("服务端socket返回："+socket.getClass());
        //3.通过socket.getInputStream()读取客户端写入的数据并显示
        InputStream inputStream = socket.getInputStream();

        //4.IO流读取
        byte[] buf = new byte[1024];
        int readline = 0;
        StringBuilder response = new StringBuilder();
        while ((readline = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readline));
        }


        //5.获取socket相关的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        //设置结束标记
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");

    }
}
