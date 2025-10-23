package java8.emp;

public record EmpRecord(String name, int id) {

  public String toString() {
    return this.name + " " + this.id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || this.getClass() != obj.getClass()) {
      return false;
    }
    EmpRecord emp = (EmpRecord) obj;
    return this.name().equals(emp.name()) && this.id() == emp.id();
  }

  @Override
  public int hashCode() {
    int hashCode = 1;
    final int prime = 31;
    hashCode = prime * hashCode + this.id();
    hashCode = prime * hashCode + (null == this.name() ? 0 : this.name().hashCode());
    return hashCode;
  }

  public static void main(String[] args) {
    EmpRecord emp1 = new EmpRecord("Abhinaw", 1);
    EmpRecord emp2 = new EmpRecord("Abhinaw", 1);
    System.out.println(emp1);
    System.out.println(emp2);
    System.out.println(emp1.equals(emp2));
    System.out.println(emp1.hashCode() == emp2.hashCode());
  }
}
