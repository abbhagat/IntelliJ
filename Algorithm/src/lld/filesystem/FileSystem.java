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
    String[] parts = Arrays.stream(path.split("/")).filter(s -> !s.isEmpty()).toArray(String[]::new);
    Directory parentDir = getParentDir(parts);
    String fileName = parts[parts.length - 1];
    if (parentDir.getNode(fileName) == null) {
      parentDir.addNode(new File(fileName, parentDir));
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
    File file = getFile(path);
    return file.read();
  }

  public List<String> ls(String path) {
    FileSystemNode node = traverse(path, false);
    if (node.isDirectory()) {
      Directory directory = (Directory) node;
      List<String> result = new ArrayList<>();
      for (FileSystemNode child : directory.getAllFileSystemNodes()) {
        result.add(child.getName());
      }
      return result;
    }
    return List.of(node.getName());
  }

  public void delete(String path) {
    FileSystemNode node = traverse(path, false);
    if (node == root) {
      throw new IllegalArgumentException("Cannot delete root");
    }
    node.getParent().remove(node.getName());
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
    String[] dirNames = Arrays.stream(path.split("/")).filter(s -> !s.isEmpty()).toArray(String[]::new);
    Directory currDir = root;
    for (int i = 0; i < dirNames.length; i++) {
      String dirName = dirNames[i];
      FileSystemNode node = currDir.getNode(dirName);
      if (node == null) {
        if (!createDirectories) {
          throw new IllegalArgumentException("Path not found: " + path);
        }
        Directory directory = new Directory(dirName, currDir);  // We are creating directories, so create one
        currDir.addNode(directory);
        currDir = directory;
        continue;
      }
      if (i == dirNames.length - 1) {  // If this is the last component, it can be either File or Directory.
        return node;
      }
      if (!node.isDirectory()) {  // Intermediate component must be a directory
        throw new IllegalArgumentException(dirName + " is a file");
      }
      currDir = (Directory) node;
    }
    return currDir;
  }

  private Directory getParentDir(String[] parts) {
    Directory currDir = root;
    for (int i = 0; i < parts.length - 1; i++) {
      String dirName = parts[i];
      FileSystemNode node = currDir.getNode(dirName);
      if (node instanceof Directory) {
        currDir = (Directory) node;
      } else {
        throw new IllegalArgumentException("Invalid path");
      }
    }
    return currDir;
  }

}
