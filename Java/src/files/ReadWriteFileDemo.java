package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFileDemo {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\SQL\\Abhinaw Bhagat-Resume.doc");
        FileWriter fw = new FileWriter("C:\\Users\\ABBHAGAT\\Desktop\\Abhinaw Bhagat-Resume.doc");
        BufferedReader R = new BufferedReader(fr);
        String s = "";
        while ((s = R.readLine()) != null) {
            fw.write(s + "\n");
        }
        fr.close();
        fw.close();
    }
}
