package Buffered_;

import IOStream.IO;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "src/Text/text.txt";
        String destFilePath = "src/Text/text02.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null){
                br.close();
            }
            if (bw != null){
                bw.close();
            }
        }
    }
}
