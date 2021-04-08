package javaa.interfaces;

import javaa.emp.Employee;

@FunctionalInterface
interface I {
	String getName(Employee emp);
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		I i = (emp) -> emp.getId() == 1 ? "A" : "B";
		String name = i.getName(new Employee("X", 1));
		System.out.println(name);
	}

//	public String getName(Employee emp){
//		if(emp.getId()==1){
//			return "A";
//		}else{
//			return "B";
//		}
//	}
}
