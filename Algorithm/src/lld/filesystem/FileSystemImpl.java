package lld.filesystem;

import java.util.List;

/**
 *  create existing file
 *  create file inside non-existing directory
 *  read directory
 *  delete non-empty directory
 *  duplicate directory
 *  invalid path
 *  root directory "/"
 */

public class FileSystemImpl {

  public static void main(String[] args) {

    FileSystem fileSystem = new FileSystem();

    fileSystem.mkdir("/a/b");                  // 1. Create directories

    fileSystem.createFile("/a/b/file1.txt");   // 2. Create files
    fileSystem.createFile("/a/b/file2.txt");

    fileSystem.write("/a/b/file1.txt", "Hello");   //  3. Write content

    fileSystem.append("/a/b/file1.txt", " World");  // 4. Append content

    String content = fileSystem.read("/a/b/file1.txt");   // 5. Read file
    System.out.println("File content:");
    System.out.println(content);

    List<String> files = fileSystem.ls("/a/b");    // 6. List directory

    System.out.println("\nFiles in /a/b:");
    files.forEach(System.out::println);

    fileSystem.delete("/a/b/file2.txt");         // 7. Delete file

    System.out.println("\nAfter deleting file2.txt:");
    fileSystem.ls("/a/b").forEach(System.out::println);
  }
}
