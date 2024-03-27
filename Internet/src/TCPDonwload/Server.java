package TCPDonwload;

import TCP.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP文件下载
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //1.监听9999端口，等待客户端连接并发送需要下载的文件的名称
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的要下载的文件名
        //使用while循环读取文件名时考虑了客户端发送数据较大的情况
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downloadFileName = "";
        while((len = inputStream.read(b)) != -1){
            downloadFileName += new String(b,0,len);
        }
        System.out.println("客户希望下载的文件名："+ downloadFileName);

        //如果客户端下载01.jpeg就返回该文件，否则一律默认返回02
        String resFileName = "";
        if ("01".equals(downloadFileName)){
            resFileName = "out/production/Internet/01.jpeg";
        }else {
            resFileName = "out/production/Internet/02.jpeg";
        }

        //4.创建一个循环输入流读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //得到socket关联的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);

        socket.shutdownOutput();

        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出");

    }
}
