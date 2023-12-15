package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    // Test addContact method
    @Test
    public void testAddContact() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        assertNotNull(contactService.getContact("1234567890"), "Contact should be added successfully");
    }

    @Test
    public void testAddContactWithDuplicateID() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("1234567890", "Clark", "Kent", "0987654321", "Metropolis");
        }, "Should throw exception for duplicate ID");
    }

    // Test getContact method
    @Test
    public void testGetContact() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        Contact contact = contactService.getContact("1234567890");
        assertEquals("Bruce", contact.getFirstName(), "Retrieved contact should have correct first name");
    }

    @Test
    public void testGetNonExistentContact() {
        assertNull(contactService.getContact("nonexistent"), "Should return null for a non-existent contact ID");
    }

    // Test updateContact method
    @Test
    public void testUpdateContactFirstName() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        contactService.updateContactFirstName("1234567890", "Batman");
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Batman", updatedContact.getFirstName(), "Contact first name should be updated");
    }
    
    @Test
    public void testUpdateContactLastName() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        contactService.updateContactLastName("1234567890", "Knight");
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Knight", updatedContact.getLastName(), "Contact last name should be updated");
    }
    
    @Test
    public void testUpdateContactPhone() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        contactService.updateContactPhone("1234567890", "9876543210");
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("9876543210", updatedContact.getPhoneNumber(), "Contact phone number should be updated");
    }
    
    @Test
    public void testUpdateContactAddress() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        contactService.updateContactAddress("1234567890", "Batcave");
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Batcave", updatedContact.getAddress(), "Contact address should be updated");
    }

    @Test
    public void testUpdateFirstNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName("nonexistent", "Clark");
        }, "Should throw exception when updating a non-existent contact");
    }
    
    @Test
    public void testUpdateLastNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactLastName("nonexistent", "Kent");
        }, "Should throw exception when updating the last name of a non-existent contact");
    }
    
    @Test
    public void testUpdatePhoneNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactPhone("nonexistent", "0987654321");
        }, "Should throw exception when updating the phone number of a non-existent contact");
    }
    
    @Test
    public void testUpdateAddressNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactAddress("nonexistent", "Metropolis");
        }, "Should throw exception when updating the address of a non-existent contact");
    }

    // Test deleteContact method
    @Test
    public void testDeleteContact() {
        contactService.addContact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"), "Contact should be deleted successfully");
    }
}