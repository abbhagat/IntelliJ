package lld.filesystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class FileSystemNode {

  @Getter
  protected String name;
  protected Directory parent;

  public abstract boolean isDirectory();
}
