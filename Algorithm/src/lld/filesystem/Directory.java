package lld.filesystem;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

class Directory extends FileSystemNode {

  private Map<String, FileSystemNode> children = new TreeMap<>();

  public Directory(String name, Directory parent) {
    super(name, parent);
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  public void add(FileSystemNode node) {
    children.put(node.getName(), node);
  }

  public FileSystemNode get(String name) {
    return children.get(name);
  }

  public void remove(String name) {
    children.remove(name);
  }

  public Collection<FileSystemNode> children() {
    return children.values();
  }
}
