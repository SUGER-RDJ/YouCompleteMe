package UDP;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建对象准备发送和接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] data = "hello,receiver".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("172.20.10.2"), 9999);

        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);

        int length = packet1.getLength();
        data = packet1.getData();
        String s = new String(data,0,length);
        System.out.println(s);


        socket.close();
        System.out.println("B端退出");
    }
}
