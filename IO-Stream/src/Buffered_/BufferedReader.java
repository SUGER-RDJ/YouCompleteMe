package Buffered_;

import java.io.FileReader;

/**
 * 节点流可以从一个特定的数据源读写数据，如FileReader，FileWriter
 * 处理流（也叫包装流）是“连接”在已存在的流（节点流或处理流之上），为程序提供更强大的读写功能，如BufferedReader，BufferedWriter
 * 处理流能提高性能，主要以增加缓冲的方式提高输入输出效率
 * 操作便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量数据，使使用更加灵活方便
 * BufferReader中有属性Reader，即可以封装一个节点流，该节点流是任意的，只要是Reader的子类即可
 */
public class BufferedReader {
    public static void main(String[] args) throws Exception{
        String filePath = "src/Text/story.txt";
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new FileReader(filePath)); //BufferedReader底层是FileReader
        String line;  //按行读取
        while ((line = bufferedReader.readLine()) != null){ //当返回一个空时表示读取完毕
            System.out.println(line);
        }
        //关闭流，只需要关闭BufferedReader，因为底层会自动关闭节点流
        bufferedReader.close();
    }
}
