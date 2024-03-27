package TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFIleUploadClient {
    public static void main(String[] args) throws Exception {
        //1.创建客户端连接服务器，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //2.创建读取磁盘文件的输入流
        String filePath = "out/production/Internet/01.jpeg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流，将byte数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);  //将文件对应的字节内容，写入到数据通道

        bis.close();
        socket.shutdownOutput(); //设置写入数据的结束标记

        //接受从服务端恢复的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bos.close();
        socket.close();

    }
}
