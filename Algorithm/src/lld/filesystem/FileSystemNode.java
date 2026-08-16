package lld.filesystem;

abstract class FileSystemNode {

  protected String name;
  protected Directory parent;

  protected FileSystemNode(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public abstract boolean isDirectory();
}
