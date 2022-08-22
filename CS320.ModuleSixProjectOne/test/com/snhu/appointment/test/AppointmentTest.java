package com.snhu.appointment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.snhu.appointment.Appointment;

class AppointmentTest {

	// variables
	private String appointmentId;
	private String appointmentDescription;
	private String appointmentIdThatIsTooLong;
	private String appointmentDescriptionThatIsTooLong;
	private Date date;
	private Date pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		appointmentId = "1234567890";
		appointmentDescription = "The appointment description.";
		date = new Date(2022, Calendar.SEPTEMBER, 1);
		appointmentIdThatIsTooLong = "12345678901";
		appointmentDescriptionThatIsTooLong = "This description is too long for the appointment description requirements.";
		pastDate = new Date(0);
	}

	@Test
	void testUpdateAppointmentId() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class, () -> appt.updateAppointmentId(null));
		assertThrows(IllegalArgumentException.class, () -> appt.updateAppointmentId(appointmentIdThatIsTooLong));
		appt.updateAppointmentId(appointmentId);
		assertEquals(appointmentId, appt.getAppointmentId());
	}

	@Test
	void testGetAppointmentId() {
		Appointment appt = new Appointment(appointmentId);
		assertNotNull(appt.getAppointmentId());
		assertEquals(appt.getAppointmentId().length(), 10);
		assertEquals(appointmentId, appt.getAppointmentId());
	}

	@Test
	void testUpdateDate() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
		assertThrows(IllegalArgumentException.class, () -> appt.updateDate(pastDate));
		appt.updateDate(date);
		assertEquals(date, appt.getAppointmentDate());
	}

	@Test
	void testGetAppointmentDate() {
		Appointment appt = new Appointment(appointmentId, date);
		assertNotNull(appt.getAppointmentDate());
		assertEquals(date, appt.getAppointmentDate());
	}

	@Test
	void testUpdateDescription() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class, () -> appt.updateDescription(null));
		assertThrows(IllegalArgumentException.class, () -> appt.updateDescription(appointmentDescriptionThatIsTooLong));
		appt.updateDescription(appointmentDescription);
		assertEquals(appointmentDescription, appt.getDescription());
	}

	@Test
	void testGetDescription() {
		Appointment appt = new Appointment(appointmentId, date, appointmentDescription);
		assertNotNull(appt.getDescription());
		assertTrue(appt.getDescription().length() <= 50);
		assertEquals(appointmentDescription, appt.getDescription());
	}

}
