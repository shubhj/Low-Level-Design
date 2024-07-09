package client;

import java.util.ArrayList;

import component.Employee;
import component.IndividualContributor;
import component.Manager;

public class Client {

	public static void main(String[] args) {
		Employee employee1 =  new IndividualContributor("IC-1", "ic1@company.com");
		Employee employee2 =  new IndividualContributor("IC-2", "ic2@company.com");
		Manager employee3 =  new Manager("Manager-1", "manager1@company.com", new ArrayList<>());
		Manager employee4 =  new Manager("Manager-2", "manager2@company.com", new ArrayList<>());
		Employee employee5 =  new IndividualContributor("IC-3", "ic3@company.com");
		Manager employee6 =  new Manager("Manager-3", "manager3@company.com", new ArrayList<>());
		
		employee3.addEmployee(employee1);
		
		employee4.addEmployee(employee2);
		employee4.addEmployee(employee3);
		
		
		employee6.addEmployee(employee5);
		employee6.addEmployee(employee4);
		
		employee6.displayDetails("CEO");

	}

}
