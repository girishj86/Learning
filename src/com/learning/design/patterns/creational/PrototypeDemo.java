package com.learning.design.patterns.creational;

public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Department dept1 = new Department("Dev", 500);
		Employee emp1 = new Employee("Ajay", 100, dept1);
		Employee emp2 = (Employee) emp1.clone();
		System.out.println(emp1.name+" "+emp2.name);
		System.out.println(emp1.name==emp2.name);
		System.out.println(emp1.department.name+" "+emp2.department.name);
		System.out.println(emp1.department==emp2.department);
		emp1.department.name = "Dev2";
		System.out.println(emp2.department.name);
		
		// java examples
		// java.lang.Object#clone() (class should implement the java.lang.Cloneable interface)

	}

}

class Department implements Cloneable {
	
	String name;
	int id;

	public Department(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

class Employee implements Cloneable {
	
	String name;
	int id;
	Department department;

	public Employee(String name, int id, Department department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// By default, shallow copies are created when cloned
		//creates shallow copy, same department is shared
		//return super.clone();
		
		//creates deep copy of department, different departments shared
		Employee e = (Employee) super.clone();
		e.department = (Department) e.department.clone();
		return e;
	}
	
}