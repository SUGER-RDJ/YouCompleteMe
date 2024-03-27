package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象，准备接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个DatagramPacket对象，准备接收数据
        byte[] buf = new byte[64*1024]; //udp最大传输64k数据
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.调用接收方法,将通过网络传输的DatagramPacket对象填充到packet对象
        socket.receive(packet);

        //4.数据进行拆包，并显示
        int length = packet.getLength(); //实际接收到的数据长度
        byte[] data = packet.getData(); //接收到数据
        String s = new String(data,0,length);
        System.out.println(s);

        data = "hello,sender".getBytes();
        packet = new DatagramPacket(data,data.length, InetAddress.getByName("172.20.10.2"),9998);

        socket.send(packet);

        socket.close();
        System.out.println("A端退出");

    }
}
