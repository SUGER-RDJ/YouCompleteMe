package transformation;

import java.io.FileOutputStream;

/**
 * FileOutputStream字节流转换为字符流OutputStreamWriter
 */
public class OutputStreamWriter {
    public static void main(String[] args) throws Exception{
        String filePath = "src/Text/trans.txt";
        String charset = "gbk";
        java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(new FileOutputStream(filePath),charset);
        osw.write("hi,哈哈哈");
        osw.close();
        System.out.println("按照" + charset + "保存文件成功");
    }
}
