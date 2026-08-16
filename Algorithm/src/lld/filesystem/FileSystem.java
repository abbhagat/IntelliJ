package lld.filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSystem {

  private final Directory root = new Directory("/", null);

  public void mkdir(String path) {
    traverse(path, true);
  }

  public void createFile(String path) {
    String[] parts = split(path);
    Directory parent = (Directory) traverseParent(parts);
    String fileName = parts[parts.length - 1];
    if (parent.get(fileName) == null) {
      parent.add(new File(fileName, parent));
    }
  }

  public void write(String path, String content) {
    File file = getFile(path);
    file.write(content);
  }

  public void append(String path, String content) {
    File file = getFile(path);
    file.append(content);
  }

  public String read(String path) {
    return getFile(path).read();
  }

  public List<String> ls(String path) {
    FileSystemNode node = traverse(path, false);
    if (!node.isDirectory()) {
      return List.of(node.getName());
    }
    Directory directory = (Directory) node;
    List<String> result = new ArrayList<>();
    for (FileSystemNode child : directory.children()) {
      result.add(child.getName());
    }
    return result;
  }

  public void delete(String path) {
    FileSystemNode node = traverse(path, false);
    if (node == root) {
      throw new IllegalArgumentException("Cannot delete root");
    }
    node.parent.remove(node.name);
  }

  private File getFile(String path) {
    FileSystemNode node = traverse(path, false);
    if (!(node instanceof File)) {
      throw new IllegalArgumentException("Not a file");
    }
    return (File) node;
  }
  private FileSystemNode traverse(String path, boolean createDirectories) {
    if (path.equals("/")) {
      return root;
    }
    String[] parts = split(path);
    Directory current = root;
    for (int i = 0; i < parts.length; i++) {
      String part = parts[i];
      FileSystemNode node = current.get(part);
      // Node does not exist
      if (node == null) {
        if (!createDirectories) {
          throw new IllegalArgumentException("Path not found: " + path);
        }
        // We are creating directories, so create one
        Directory newDir = new Directory(part, current);
        current.add(newDir);
        current = newDir;
        continue;
      }
      // If this is the last component, it can be either File or Directory.
      if (i == parts.length - 1) {
        return node;
      }
      // Intermediate component must be a directory
      if (!node.isDirectory()) {
        throw new IllegalArgumentException(part + " is a file");
      }
      current = (Directory) node;
    }
    return current;
  }

  private FileSystemNode traverseParent(String[] parts) {
    Directory current = root;
    for (int i = 0; i < parts.length - 1; i++) {
      FileSystemNode node = current.get(parts[i]);
      if (!(node instanceof Directory)) {
        throw new IllegalArgumentException("Invalid path");
      }
      current = (Directory) node;
    }
    return current;
  }

  private String[] split(String path) {
    return Arrays.stream(path.split("/"))
                 .filter(s -> !s.isEmpty())
                 .toArray(String[]::new);
  }
}
