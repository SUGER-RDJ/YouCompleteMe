package ReaderAndWriter;

import java.io.IOException;

public class FileReader {
    public static void main(String[] args) throws IOException {

        String filePath = "src/Text/story.txt";
        java.io.FileReader fileReader = null;
        int data = ' ';
        try {
            fileReader = new java.io.FileReader(filePath);
            while ((data = fileReader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (fileReader != null){
                fileReader.close();
            }
        }
    }
}
