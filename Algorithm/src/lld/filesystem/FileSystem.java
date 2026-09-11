package lld.filesystem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystem {

  private final Directory root;

  public FileSystem() {
    this.root = new Directory("/", null);
  }

  public void mkdir(String path) {
    traversePath(path);
  }

  public void createFile(String path) {
    String[] parts      = Arrays.stream(path.split("/")).filter(s -> !s.isEmpty()).toArray(String[]::new);
    Directory parentDir = getParentDir(parts);
    String fileName     = parts[parts.length - 1];
    FileSystemNode node = parentDir.getNode(fileName);
    if (node == null) {
      File file = new File(fileName, parentDir);
      parentDir.addNode(file);
    }
  }

  private FileSystemNode traversePath(String path) {
    if (path.equals("/")) {
      return root;
    }
    String[] dirNames = Arrays.stream(path.split("/")).filter(s -> !s.isEmpty()).toArray(String[]::new);
    Directory currDir = root;
    for (int i = 0; i < dirNames.length; i++) {
      String dirName = dirNames[i];
      FileSystemNode node = currDir.getNode(dirName);
      if (node == null) {
        Directory directory = new Directory(dirName, currDir);  // We are creating directories, so create one
        currDir.addNode(directory);
        currDir = directory;
        continue;
      }
      if (i == dirNames.length - 1) {  // If this is the last component, it can be either File or Directory.
        return node;
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
      currDir = node instanceof Directory ? (Directory) node : currDir;
    }
    return currDir;
  }

  public void write(String path, String content) {
    File file = (File) traversePath(path);
    file.write(content);
  }

  public void append(String path, String content) {
    File file = (File) traversePath(path);
    file.append(content);
  }

  public String read(String path) {
    File file = (File) traversePath(path);
    return file.read();
  }

  public List<String> ls(String path) {
    FileSystemNode node = traversePath(path);
    if (node.isDirectory()) {
      Directory directory = (Directory) node;
      return directory.getAllFileSystemNodes()
                      .stream()
                      .map(FileSystemNode::getName)
                      .collect(Collectors.toList());
    }
    return List.of(node.getName());
  }

  public void delete(String path) {
    FileSystemNode node = traversePath(path);
    if (node == root) {
      throw new IllegalArgumentException("Cannot delete root");
    }
    node.getParent().remove(node.getName());
  }

}
