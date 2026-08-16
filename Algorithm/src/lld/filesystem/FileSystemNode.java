package lld.filesystem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
abstract class FileSystemNode {

  protected String name;
  protected Directory parent;

  public String getName() {
    return name;
  }

  public abstract boolean isDirectory();
}
