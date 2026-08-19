package lld.filesystem;

public class File extends FileSystemNode {

  private final StringBuilder fileContent;

  public File(String name, Directory parent) {
    super(name, parent);
    fileContent = new StringBuilder();
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  public String read() {
    return fileContent.toString();
  }

  public void write(String data) {
    fileContent.setLength(0);
    fileContent.append(data);
  }

  public void append(String data) {
    fileContent.append(data);
  }

}
