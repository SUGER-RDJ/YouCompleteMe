package TCPDonwload;

import TCP.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要下载的文件");
        String downloadFileName = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());

        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String filePath = "src/TCPDonwload/" + downloadFileName + ".jpeg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

        bos.write(bytes);

        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端下载完毕，退出");

    }
}
