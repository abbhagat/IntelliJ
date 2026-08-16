package lld.filesystem;

import java.util.List;

public class FileSystemImpl {

  public static void main(String[] args) {

    FileSystem fileSystem = new FileSystem();

    // 1. Create directories
    fileSystem.mkdir("/a/b/c");

    // 2. Create files
    fileSystem.createFile("/a/b/c/file1.txt");
    fileSystem.createFile("/a/b/c/file2.txt");

    // 3. Write content
    fileSystem.write("/a/b/c/file1.txt", "Hello");

    // 4. Append content
    fileSystem.append("/a/b/c/file1.txt", " World");

    // 5. Read file
    String content = fileSystem.read("/a/b/c/file1.txt");

    System.out.println("File content:");
    System.out.println(content);

    // 6. List directory
    List<String> files = fileSystem.ls("/a/b/c");

    System.out.println("\nFiles in /a/b/c:");
    files.forEach(System.out::println);

    // 7. Delete file
    fileSystem.delete("/a/b/c/file2.txt");

    System.out.println("\nAfter deleting file2.txt:");

    fileSystem.ls("/a/b/c")
        .forEach(System.out::println);
  }
}
