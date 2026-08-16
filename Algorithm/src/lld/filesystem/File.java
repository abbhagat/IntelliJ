package lld.filesystem;

class File extends FileSystemNode {

  private StringBuilder content = new StringBuilder();

  public File(String name, Directory parent) {
    super(name, parent);
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  public void write(String data) {
    content.setLength(0);
    content.append(data);
  }

  public void append(String data) {
    content.append(data);
  }

  public String read() {
    return content.toString();
  }
}
