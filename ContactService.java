package grandStrandSystems;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contactMap = new HashMap<>();
    

    // Method to add a contact
    public void addContact (String ID, String firstName, String lastName, String phoneNumber, String address) {
    	if (!contactMap.containsKey(ID)) {
    		Contact newContact = new Contact(ID, firstName, lastName, phoneNumber, address);
    		contactMap.put(ID,  newContact);
    	}
    	
    	else {
    		throw new IllegalArgumentException("A contact already exists with this ID.");
    	}
    }
    
    public Contact getContact (String ID) {
    	return contactMap.get(ID);
    }
    
    public void deleteContact (String ID) {
    	contactMap.remove(ID);
    }
    
    public void updateContactFirstName(String contactId, String firstName) {
        if (contactMap.containsKey(contactId)) {
            Contact contactToUpdate = contactMap.get(contactId);
            contactToUpdate.setFirstName(firstName);
        } 
        
        else {
            throw new IllegalArgumentException("No contact exists with this ID.");
        }
    }

    public void updateContactLastName(String contactId, String lastName) {
        if (contactMap.containsKey(contactId)) {
            Contact contactToUpdate = contactMap.get(contactId);
            contactToUpdate.setLastName(lastName);
        } 
        
        else {
            throw new IllegalArgumentException("No contact exists with this ID.");
        }
    }

    public void updateContactPhone(String contactId, String number) {
        if (contactMap.containsKey(contactId)) {
            Contact contactToUpdate = contactMap.get(contactId);
            contactToUpdate.setPhoneNumber(number);
        } 
        
        else {
            throw new IllegalArgumentException("No contact exists with this ID.");
        }
    }

    public void updateContactAddress(String contactId, String address) {
        if (contactMap.containsKey(contactId)) {
            Contact contactToUpdate = contactMap.get(contactId);
            contactToUpdate.setAddress(address);
        } 
        
        else {
            throw new IllegalArgumentException("No contact exists with this ID.");
        }
    }
}