package PrintStream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流只有输出流没有输入流
 * PrintStream字节打印流
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.print("hello,world");
        //在默认情况下，输出数据的位置为标准输出，即显示器

        out.write("hello,world".getBytes());
        //使用print或write方法在底层代码是一样的，所以我们可以直接调用write进行打印输出

        //可以修改打印流输出位置/设备
        //setOut方法修改输出位置
        System.setOut(new PrintStream("src/Text/print.txt"));
        System.out.println("helloWorld");

        out.close();
    }
}
