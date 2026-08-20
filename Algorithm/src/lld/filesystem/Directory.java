package lld.filesystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemNode {

  private final Map<String, FileSystemNode> map;

  public Directory(String name, Directory parent) {
    super(name, parent);
    map = new HashMap<>();
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  public void add(FileSystemNode node) {
    map.put(node.getName(), node);
  }

  public FileSystemNode get(String name) {
    return map.get(name);
  }

  public void remove(String name) {
    map.remove(name);
  }

  public Collection<FileSystemNode> getAllFileSystemNodes() {
    return map.values();
  }
}
