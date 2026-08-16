package lld.filesystem;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Directory extends FileSystemNode {

  private final Map<String, FileSystemNode> nodeMap = new TreeMap<>();

  public Directory(String name, Directory parent) {
    super(name, parent);
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  public void add(FileSystemNode node) {
    nodeMap.put(node.getName(), node);
  }

  public FileSystemNode get(String name) {
    return nodeMap.get(name);
  }

  public void remove(String name) {
    nodeMap.remove(name);
  }

  public Collection<FileSystemNode> getAllFileSystemNodes() {
    return nodeMap.values();
  }
}
