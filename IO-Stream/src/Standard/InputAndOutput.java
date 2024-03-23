package Standard;

/**
 * System类的public final static InputStream in = null;
 * System.in编译类型 InputStream
 * System.in运行类型 BufferedInputStream
 * System类的public final static OutputStream in = null;
 * System.in编译类型 PrintStream
 * System.in运行类型 PrintStream
 * 表示标准输出显示器
 */
public class InputAndOutput {
    public static void main(String[] args) {

        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());

    }
}
