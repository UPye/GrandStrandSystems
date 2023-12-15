package grandStrandSystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    @Test
    public void testAddAppointment() throws ParseException {
        String id = "A123";
        String date = "2023-12-31";
        String description = "Test Appointment";

        service.addAppointment(id, date, description);
        Appointment appointment = service.getAppointment(id);

        assertNotNull(appointment);
        assertEquals(id, appointment.getAppointmentID());
        assertEquals(date, new SimpleDateFormat("yyyy-MM-dd").format(appointment.getAppointmentDate()));
        assertEquals(description, appointment.getAppointmentDescription());
    }

    @Test
    public void testAddDuplicateAppointment() throws ParseException {
        String id = "A123";
        String date = "2023-12-31";
        String description = "Test Appointment";

        service.addAppointment(id, date, description);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(id, date, description);
        });

        String expectedMessage = "Appointment ID already exists.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testDeleteAppointment() throws ParseException {
        String id = "A123";
        String date = "2023-12-31";
        String description = "Test Appointment";

        service.addAppointment(id, date, description);
        service.deleteAppointment(id);

        assertNull(service.getAppointment(id));
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        String id = "A123";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment(id);
        });

        String expectedMessage = "Appointment ID does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}