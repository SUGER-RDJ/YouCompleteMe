package PrintStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "src/Text/print.txt";
        //PrintWriter writer = new PrintWriter(System.out);
        PrintWriter writer = new PrintWriter(new FileWriter(filePath));
        writer.println("hi,world");
        writer.close();
    }
}
