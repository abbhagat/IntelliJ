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

    fileSystem.mkdir("/a/b/c");                  // 1. Create directories

    fileSystem.createFile("/a/b/c/file1.txt");   // 2. Create files
    fileSystem.createFile("/a/b/c/file2.txt");

    fileSystem.write("/a/b/c/file1.txt", "Hello");   //  3. Write content

    fileSystem.append("/a/b/c/file1.txt", " World");  // 4. Append content

    String content = fileSystem.read("/a/b/c/file1.txt");   // 5. Read file
    System.out.println("File content:");
    System.out.println(content);

    List<String> files = fileSystem.ls("/a/b/c");    // 6. List directory

    System.out.println("\nFiles in /a/b/c:");
    files.forEach(System.out::println);

    fileSystem.delete("/a/b/c/file2.txt");         // 7. Delete file

    System.out.println("\nAfter deleting file2.txt:");
    fileSystem.ls("/a/b/c").forEach(System.out::println);
  }
}
