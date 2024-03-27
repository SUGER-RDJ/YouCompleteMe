package TCPDonwload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws Exception {
        /**
         * 功能：将输入流转换为byte[],即可把文件内容读入到byte
         */
        // 创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 字节数组
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            // 循环读取
            // 把读取到的数据，写入 bos
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    /**
     * 功能：将InputStream转换成String
     */

    public static String streamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line + "\r\n");
        }
        return builder.toString();
    }
}

