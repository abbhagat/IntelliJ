package java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReadDemo {

    public static void main(String[] args) {

        String fileName = "C:/Users/Admin/Desktop/IntelliJ License.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//            String line = stream.collect(Collectors.joining("\n"));
//            System.out.println(line);
            stream.forEach(line-> {
                line += ";";
                System.out.println(line);
            });
//            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
