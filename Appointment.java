package grandStrandSystems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
    private String appointmentID;
    private Date appointmentDate;
    private String appointmentDescription;

    // Constructor
    public Appointment(String appointmentID, String appointmentDateString, String appointmentDescription) throws ParseException {
        if (appointmentID == null || appointmentID.length() > 10 ) {
            throw new IllegalArgumentException("ID must be less than or equal to 10 characters and not null.");
        } else {
            this.appointmentID = appointmentID;
            setAppointmentDate(appointmentDateString);
            setAppointmentDescription(appointmentDescription);
        }
    }

    // Getters and Setters
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDateString) throws ParseException {
        if (appointmentDateString == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }

        // Parse the string to a Date object
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedAppointmentDate;
        try {
            parsedAppointmentDate = sdf.parse(appointmentDateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
        }

        // Remove time from the parsed date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedAppointmentDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        parsedAppointmentDate = calendar.getTime();

        // Get today's date with time set to midnight
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        // Check if the appointment date is before today
        if (parsedAppointmentDate.before(today.getTime())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }

        this.appointmentDate = parsedAppointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Appointment description cannot be null or greater than 50 characters.");
        } else {
            this.appointmentDescription = appointmentDescription;
        }
    }

    // toString method
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Appointment{" + "ID='" + appointmentID + '\'' +
                ", appointmentDate='" + (appointmentDate != null ? sdf.format(appointmentDate) : null) + '\'' +
                ", appointmentDescription='" + appointmentDescription + '\'' +
                '}';
    }
}