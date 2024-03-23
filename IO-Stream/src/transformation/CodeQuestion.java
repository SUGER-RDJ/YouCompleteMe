package transformation;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 文件乱码问题，引出转换流的必要性
 * 默认情况下，读取文件是按照UTF—8读取，如果需要读取的文件不是按UTF-8保存就会出现乱码问题
 *InputStreamReader/OutputStreamReader提供了一个方法使文件按照指定编码输入输出,将字节流包装成字符流
 * 当处理纯文本数据时，如果使用字符流效率更高，并且可以有效的解决中文问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws Exception{

        //读取text.txt文件到程序
        String filePath = "src/Text/text.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }
}
