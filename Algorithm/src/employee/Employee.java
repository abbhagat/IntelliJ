package employee;

public class Employee {

    private int id;
    private String name;
    private float salary;

    Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    //	public boolean equals(Object object){
    //		
    //		Employee obj = (Employee)object;
    //		
    //		if(this == obj ){
    //			return true;
    //		}
    //		
    //		if(obj == null || this.getClass()!= obj.getClass()){
    //			return false;
    //		}
    //		
    //		return this.getId()==obj.getId() || this.getName()==obj.getName()|| this.getSalary()== obj.getSalary();
    //	}
    //	
    //	public int hashCode(){
    //		final int prime = 31;
    //		int result = 1;
    //		result = (result*prime)+id;
    //		result = (result*prime)+((name == null)?0:name.hashCode());
    //		result = (result*prime)+(int)salary;
    //		return result;
    //	}
}
