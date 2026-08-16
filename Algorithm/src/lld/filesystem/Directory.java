package lld.filesystem;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

class Directory extends FileSystemNode {

  private final Map<String, FileSystemNode> children = new TreeMap<>();

  public Directory(String name, Directory parent) {
    super(name, parent);
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  public void add(FileSystemNode fileSystemNode) {
    children.put(fileSystemNode.getName(), fileSystemNode);
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
