package lld.filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSystem {

  private final Directory root;

  public FileSystem() {
    this.root = new Directory("/", null);
  }

  public void mkdir(String path) {
    traverse(path, true);
  }

  public void createFile(String path) {
    String[] parts = split(path);
    Directory parentDir = (Directory) traverseParent(parts);
    String fileName = parts[parts.length - 1];
    if (parentDir.get(fileName) == null) {
      parentDir.add(new File(fileName, parentDir));
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
    for (FileSystemNode child : directory.getAllFileSystemNodes()) {
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
    String[] dirNames = split(path);
    Directory currDir = root;
    for (int i = 0; i < dirNames.length; i++) {
      String dirName = dirNames[i];
      FileSystemNode node = currDir.get(dirName);
      // Node does not exist
      if (node == null) {
        if (!createDirectories) {
          throw new IllegalArgumentException("Path not found: " + path);
        }
        // We are creating directories, so create one
        Directory directory = new Directory(dirName, currDir);
        currDir.add(directory);
        currDir = directory;
        continue;
      }
      // If this is the last component, it can be either File or Directory.
      if (i == dirNames.length - 1) {
        return node;
      }
      // Intermediate component must be a directory
      if (!node.isDirectory()) {
        throw new IllegalArgumentException(dirName + " is a file");
      }
      currDir = (Directory) node;
    }
    return currDir;
  }

  private FileSystemNode traverseParent(String[] parts) {
    Directory currDir = root;
    for (int i = 0; i < parts.length - 1; i++) {
      FileSystemNode node = currDir.get(parts[i]);
      if (!(node instanceof Directory)) {
        throw new IllegalArgumentException("Invalid path");
      }
      currDir = (Directory) node;
    }
    return currDir;
  }

  private String[] split(String path) {
    return Arrays.stream(path.split("/"))
                 .filter(s -> !s.isEmpty())
                 .toArray(String[]::new);
  }
}
