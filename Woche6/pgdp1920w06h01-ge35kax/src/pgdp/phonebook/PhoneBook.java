package pgdp.phonebook;
public class PhoneBook{
	
	
	private Entry[]entries;
	
	
	
	
	public PhoneBook(Entry[]entries) {
		this.entries=entries;	
	}
	public String find(String firstName, String lastName) {	
		
		int a=0;
		int b=this.entries.length-1;
		int m;
		while(a<=b) {
			m=(b+a)/2;
			if(this.entries[m].getLastName().compareTo(lastName)==0) {
				if(this.entries[m].getFirstName().compareTo(firstName)==0) {
					return this.entries[m].getPhoneNumber();
				}
				else if(this.entries[m].getFirstName().compareTo(firstName)<0) {
					a=m+1;
				}
				else {
					b=m-1;
				}
				
			}
			
			else if(this.entries[m].getLastName().compareTo(lastName)<0) {
				a=m+1;
			}
			else {
				b=m-1;
			}	
		}
		return null;
	}
	public static void main(String[]args ){
		Entry[] entries = new Entry[5];
		entries[0] = new Entry("Agathe", "Ackermann", "555-11133322");
		entries[1] = new Entry("Celia", "Ackermann", "555-2251243");
		entries[2] = new Entry("Winfried", "Becker", "555-225123");
		entries[3] = new Entry("Alex", "Dieß", "555-343112");
		entries[4] = new Entry("Beatrix", "Dieß",  "555-2123123");
		PhoneBook phoneBook = new PhoneBook(entries);
		System.out.println(phoneBook.find("A", "A"));
	}
	
	
}