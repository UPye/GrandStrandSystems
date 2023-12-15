package grandStrandSystems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppointmentTest {

    @Test
    public void testAppointmentConstructorValidData() throws ParseException {
        String id = "1234567890";
        String date = "2023-12-31"; // Use a future date
        String description = "Appointment Description";

        Appointment appointment = new Appointment(id, date, description);

        assertEquals(id, appointment.getAppointmentID());
        assertEquals(date, new SimpleDateFormat("yyyy-MM-dd").format(appointment.getAppointmentDate()));
        assertEquals(description, appointment.getAppointmentDescription());
    }

    @Test
    public void testAppointmentConstructorInvalidId() {
        String id = "12345678901"; // 11 characters, more than 10
        String date = "2023-12-31";
        String description = "Appointment Description";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, date, description);
        });

        String expectedMessage = "ID must be less than or equal to 10 characters and not null.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAppointmentConstructorInvalidDate() {
        String id = "1234567890";
        String date = "2000-01-01"; // A past date
        String description = "Appointment Description";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, date, description);
        });

        String expectedMessage = "Appointment date cannot be in the past.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAppointmentConstructorInvalidDescription() {
        String id = "1234567890";
        String date = "2023-12-31";
        String description = "This description is way too long and definitely exceeds the fifty character limit that is set for an appointment description.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, date, description);
        });

        String expectedMessage = "Appointment description cannot be null or greater than 50 characters.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}