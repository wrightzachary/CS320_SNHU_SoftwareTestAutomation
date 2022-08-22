package com.snhu.appointment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.sql.Date;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.snhu.appointment.AppointmentService;

class AppointmentServiceTest {

	// variables
	private String appointmentId;
	private String appointmentDescription;
	private String appointmentDescriptionThatIsTooLong;
	private Date date;
	private Date pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		appointmentId = "1234567890";
		appointmentDescription = "The appointment description.";
		date = new Date(2022, Calendar.SEPTEMBER, 1);
		appointmentDescriptionThatIsTooLong = "This description is too long for the appointment description requirements.";
		pastDate = new Date(0);
	}

	@Test
	void testNewAppointment() {
		AppointmentService service = new AppointmentService();

		service.newAppointment();
		assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
		assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(0).getDescription());

		service.newAppointment(date);
		assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
		assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(1).getDescription());

		service.newAppointment(date, appointmentDescription);
		assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
		assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(appointmentDescription, service.getAppointmentList().get(2).getDescription());

		assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
				service.getAppointmentList().get(1).getAppointmentId());
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
				service.getAppointmentList().get(2).getAppointmentId());
		assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
				service.getAppointmentList().get(2).getAppointmentId());

		assertThrows(IllegalArgumentException.class, () -> service.newAppointment(pastDate));
		assertThrows(IllegalArgumentException.class, () -> service.newAppointment(date, appointmentDescriptionThatIsTooLong));
	}

	@Test
	void testDeleteAppointment() throws Exception {
		AppointmentService service = new AppointmentService();

		service.newAppointment();
		service.newAppointment();
		service.newAppointment();

		String firstId = service.getAppointmentList().get(0).getAppointmentId();
		String secondId = service.getAppointmentList().get(1).getAppointmentId();
		String thirdId = service.getAppointmentList().get(2).getAppointmentId();

		assertNotEquals(firstId, secondId);
		assertNotEquals(firstId, thirdId);
		assertNotEquals(secondId, thirdId);
		assertNotEquals(appointmentId, firstId);
		assertNotEquals(appointmentId, secondId);
		assertNotEquals(appointmentId, thirdId);

		assertThrows(Exception.class, () -> service.deleteAppointment(appointmentId));

		service.deleteAppointment(firstId);
		assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
		assertNotEquals(firstId, service.getAppointmentList().get(0).getAppointmentId());
	}

}
