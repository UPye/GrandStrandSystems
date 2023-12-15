package grandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("1234567890", "Bruce", "Wayne", "0123456789", "1007 Mountain Drive");
    }

    // Test Constructor
    @Test
    public void testContactConstructorValidData() {
        assertEquals("Bruce", contact.getFirstName(), "First name did not match the expected value");
        assertEquals("Wayne", contact.getLastName(), "Last name did not match the expected value");
        assertEquals("0123456789", contact.getPhoneNumber(), "Phone number did not match the expected value");
        assertEquals("1007 Mountain Drive", contact.getAddress(), "Address did not match the expected value");
    }

    @Test
    public void testContactConstructorInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "0123456789", "123 Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("5555555555", null, "Doe", "0123456789", "123 Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("5555555555", "John", null, "0123456789", "123 Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("5555555555", "John", "Doe", null, "123 Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("5555555555", "John", "Doe", "0123456789", null));
    }

    // Test Setters
    @Test
    public void testSetFirstNameValid() {
        contact.setFirstName("Clark");
        assertEquals("Clark", contact.getFirstName(), "First name was not updated correctly");
    }
    
    public void testLastNameValid() {
        contact.setLastName("Kent");
        assertEquals("Clark", contact.getLastName(), "Last name was not updated correctly");
    }
    
    public void testPhoneNumberValid() {
        contact.setPhoneNumber("4046785555");
        assertEquals("Clark", contact.getPhoneNumber(), "Phone number was not updated correctly");
    }
    
    public void testAddressValid() {
        contact.setAddress("123 Lane Street");
        assertEquals("Clark", contact.getAddress(), "Address was not updated correctly");
    }
        
    @Test
    public void testSetFirstNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    public void testSetLastNameInvalid() {
    	assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }
    
    public void testSetPhoneNumberInvalid() {
    	assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(null));
    }
    
    public void testSetAddressInvalid() {
    	assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
    // Test Getters
    @Test
    public void testGetFirstName() {
        assertEquals("Bruce", contact.getFirstName(), "Getter for first name failed");
    }
    
    public void testGetLastName() {
        assertEquals("Williams", contact.getLastName(), "Getter for last name failed");
    }
    
    public void testGetPhoneNumber() {
        assertEquals("6784045555", contact.getPhoneNumber(), "Getter for phone number failed");
    }
    
    public void testGetAddress() {
        assertEquals("123 Lane Street", contact.getAddress(), "Getter for address failed");
    }

    // Test toString Method
    @Test
    public void testToString() {
        String expectedString = "Contact{ID='1234567890'firstName='Bruce', lastName='Wayne', phoneNumber='0123456789', address='1007 Mountain Drive'}";
        assertEquals(expectedString, contact.toString(), "toString does not match the expected format");
    }
}