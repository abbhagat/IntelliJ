package lld.filesystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class FileSystemNode {

  protected String name;
  protected Directory parent;

  public abstract boolean isDirectory();
}
