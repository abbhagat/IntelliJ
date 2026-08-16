package lld.filesystem;

class File extends FileSystemNode {

  private final StringBuilder fileContent = new StringBuilder();

  public File(String name, Directory parent) {
    super(name, parent);
  }

  @Override
  public boolean isDirectory() {
    return true;
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
