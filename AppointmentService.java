package grandStrandSystems;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    public void addAppointment(String appointmentID, String date, String description) throws ParseException {
        if (appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        Appointment newAppointment = new Appointment(appointmentID, date, description);
        appointments.put(appointmentID, newAppointment);
    }

    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(appointmentID);
    }

    // Method to retrieve an appointment (useful for testing)
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}