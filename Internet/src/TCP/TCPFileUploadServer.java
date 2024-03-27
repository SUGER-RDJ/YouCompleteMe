package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听");
        //2.等待客户端连接
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的数据
        //通过socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //4.将得到的bytes数组写入到指定的路径，就得到一个文件
        String destFilePath = "out/production/Internet/02.jpeg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        bos.close();

        //向客户端回送消息表示接收到
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();
        socket.shutdownOutput();

        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
