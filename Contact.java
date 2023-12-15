package grandStrandSystems;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("ID must be less than or equal to 10 characters");
		}
		
		else {
			this.contactID = contactID;
			
			setFirstName(firstName);
			setLastName(lastName);
			setPhoneNumber(phoneNumber);
			setAddress(address);
		}
	}
	
	// Getters and Setters
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName !=null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("First name must be less than 11 characters and not null.");
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName !=null && lastName.length() <= 10) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException("Last name must be less than 11 characters and not null.");
		}
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber !=null && phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("Phone number must be exactly 10 characters and not null.");
		}
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (address !=null && address.length() <= 30) {
			this.address = address;
		}
		else {
			throw new IllegalArgumentException("Address must be less than 30 characters and not null.");
		}
	}
	
	// toString method
	@Override
	public String toString() {
		return "Contact{" + 
				"ID='" + contactID + '\'' + 
				"firstName='" + firstName + '\'' + 
				", lastName='" + lastName + '\'' + 
				", phoneNumber='" + phoneNumber + '\'' + 
				", address='" + address + '\'' + 
				'}';
	}
	
	
}