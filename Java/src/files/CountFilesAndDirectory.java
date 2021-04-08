package files;

import java.io.File;
import java.io.IOException;

public class CountFilesAndDirectory {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Nikita/Desktop/XYZ");
        System.out.println("Directory : " + file.getName() + "\t" + file.length());
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.isDirectory() ? "Directory " : "File " + f.getName() + "\t" + f.length());
        }
    }
}
