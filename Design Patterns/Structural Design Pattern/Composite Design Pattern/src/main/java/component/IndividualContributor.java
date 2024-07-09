package component;

public class IndividualContributor implements Employee  {
	
	private String name;
	private String mailId;
	
	public IndividualContributor(String name, String mailId ) {
		this.name=name;
		this.mailId = mailId;
	}

	@Override
	public String getName() {
		return this.name;
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
		System.out.println("Employee : "+name+"  mail id : "+mailId+" is an Individual Contributor. Its manager is : "+manager);		
	}

}
