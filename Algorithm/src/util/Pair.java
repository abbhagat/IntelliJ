package util;

public class Pair {

  public int x, y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || this.getClass() != obj.getClass()) {
      return false;
    }
    final Pair p = (Pair) obj;
    return p.x == this.x && p.y == this.y;
  }

  public int hashCode() {
    final int prime = 31;
    int hashCode = 1;
    hashCode = prime * hashCode + this.x;
    hashCode = prime * hashCode + this.y;
    return hashCode;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }

}
