package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java IO流
 * 输入input：读取外部数据（磁盘，光盘等存储设备中的数据）到程序（内存）中
 * 输出output：将程序中的数据输出到设备中
 * 按操作数据单位不同：字节流（8bit,适合二进制文件）字符流（适合文本文件）
 * 按数据的流向不同：输入流，输出流
 * 按流的角色不同：节点流，处理流/包装流
 * 字节输入流：InputStream  字节输出流：OutputStream
 * 字符输入流：Reader  字符输出流：Writer
 * 字节输入输出流，字符输入输出流都是抽象类，不能直接创建，只能用其实现子类来创建相应流对象
 */
public class IO {
    public static void main(String[] args) throws IOException {


        //IO输入流Input演示
        String filePath = "src/Text/hello.txt";
        int readData = 0;
        FileInputStream stream = null;
        try {
            //创建FileInputStream对象，用于读取文件
            stream = new FileInputStream(filePath);
            //read方法：从该输入流读取一个字节的数据，如果没有输入可用，返回-1表示读取完毕
            while ((readData = stream.read()) != -1){
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭文件释放资源
            stream.close();
        }


        //IO输出流Output演示
        String filePath2 = "src/Text/text.txt";
        FileOutputStream stream2 = null;

        try {
            stream2 = new FileOutputStream(filePath2);
            stream2.write('a');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            stream2.close();
        }

    }
}

