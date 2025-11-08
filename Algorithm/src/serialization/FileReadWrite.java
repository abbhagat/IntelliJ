package serialization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Admin\\Downloads\\IntelliJ.pdf");
        FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Downloads\\License.txt");
        BufferedReader R = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = R.readLine()) != null) {
            sb.append(s);
        }
        System.out.println(sb);
        fileWriter.write(sb.toString());
        fileReader.close();
        fileWriter.close();
    }
}
