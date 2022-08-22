package com.snhu.appointment;

import java.util.Date;

public class Appointment {

	// variables
	final private byte APPOINTMENT_ID_LENGTH;
	final private byte APPOINTMENT_DESCRIPTION_LENGTH;
	final private String INITIALIZER;
	private String appointmentId;
	private Date appointmentDate;
	private String appointmentDescription;

	{
		APPOINTMENT_ID_LENGTH = 10;
		APPOINTMENT_DESCRIPTION_LENGTH = 50;
		INITIALIZER = "INITIAL";
	}

	// setting initial values of variables
	public Appointment() {
		Date today = new Date();
		appointmentId = INITIALIZER;
		appointmentDate = today;
		appointmentDescription = INITIALIZER;
	}

	// setting the id
	public Appointment(String id) {
		Date today = new Date();
		updateAppointmentId(id);
		appointmentDate = today;
		appointmentDescription = INITIALIZER;
	}

	// setting the id
	public Appointment(String id, Date date) {
		updateAppointmentId(id);
		updateDate(date);
		appointmentDescription = INITIALIZER;
	}

	// setting the description
	public Appointment(String id, Date date, String appointmentDescription) {
		updateAppointmentId(id);
		updateDate(date);
		updateDescription(appointmentDescription);
	}

	// update appointment id
	public void updateAppointmentId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Appointment Id cannot be null.");
		} else if (id.length() > APPOINTMENT_ID_LENGTH) {
			throw new IllegalArgumentException(
					"Appointment ID cannot exceed " + APPOINTMENT_ID_LENGTH + " characters.");
		} else {
			this.appointmentId = id;
		}
	}

	// return appointment id
	public String getAppointmentId() {
		return appointmentId;
	}

	// update date
	public void updateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Appointment date cannot be null.");
		} else if (date.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment with a past date.");
		} else {
			this.appointmentDate = date;
		}
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void updateDescription(String appointmentDescription) {
		if (appointmentDescription == null) {
			throw new IllegalArgumentException("Appointment description cannot be null.");
		} else if (appointmentDescription.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException(
					"Appointment description cannot exceed " + APPOINTMENT_DESCRIPTION_LENGTH + " characters.");
		} else {
			this.appointmentDescription = appointmentDescription;
		}
	}

	public String getDescription() {
		return appointmentDescription;
	}
}
