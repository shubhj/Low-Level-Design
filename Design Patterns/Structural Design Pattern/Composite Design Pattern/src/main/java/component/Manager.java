package component;

import java.util.List;

public class Manager implements Employee {
	private String name;
	private String mailId;
	
	List<Employee> employees;
	
	public Manager(String name, String mailId, List<Employee> employees ){
		this.name=name;
		this.mailId=mailId;
		this.employees = employees;
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
		
	}

	@Override
	public String getMailId() {
		return mailId;
	}

	@Override
	public void setMailId(String mailId) {
		this.mailId=mailId;
		
	}

	@Override
	public void displayDetails(String manager) {
		System.out.println("Employee : "+name+"  mail id : "+mailId+" is a Manager  . Its manager is : "+manager);
		for(Employee employee : employees)
				employee.displayDetails(this.name);
		
		
	}

}
