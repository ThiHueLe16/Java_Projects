package pgdp.phonebook;
public class Entry{
	private String lastName;
	private String firstName;
	private String phoneNumber;
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	//Kontruktor
	public Entry(String firstName, String lastName, String phoneNumber){
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
	}
}