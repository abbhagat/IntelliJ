package lld.filesystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemNode {

  private final Map<String, FileSystemNode> nodeMap;

  public Directory(String name, Directory parent) {
    super(name, parent);
    nodeMap = new HashMap<>();
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  public void addNode(FileSystemNode node) {
    nodeMap.put(node.getName(), node);
  }

  public FileSystemNode getNode(String name) {
    return nodeMap.get(name);
  }

  public void remove(String name) {
    nodeMap.remove(name);
  }

  public Collection<FileSystemNode> getAllFileSystemNodes() {
    return nodeMap.values();
  }

}
