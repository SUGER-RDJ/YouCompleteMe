package transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;

/**
 * 演示使用InputStreamReader解决中文乱码问题
 * 将字节流FileInputStream转换成字符流InputStreamReader，指定编码gbk
 */
public class InputStreamReader {
    public static void main(String[] args) throws Exception{
        String filePath = "src/Text/text.txt";
        //将字节流转换为字符流，同时指定了编码
        java.io.InputStreamReader isr = new java.io.InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println(s);
        br.close();

    }
}
