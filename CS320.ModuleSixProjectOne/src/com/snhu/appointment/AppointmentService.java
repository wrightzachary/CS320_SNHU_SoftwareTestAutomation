package com.snhu.appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	
	// array list to hold appointments
	final private List<Appointment> appointmentList = new ArrayList<>();

	// return a random unique ID
	private String newUniqueId() 	{
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	// add a new appointmentId to list
	public void newAppointment() {
		Appointment appt = new Appointment(newUniqueId());
		appointmentList.add(appt);
	}

	// and new appointment date
	public void newAppointment(Date date) {
		Appointment appt = new Appointment(newUniqueId(), date);
		appointmentList.add(appt);
	}

	// add new description to list 
	public void newAppointment(Date date, String description) {
		Appointment appt = new Appointment(newUniqueId(), date, description);
		appointmentList.add(appt);
	}

	// delete appointment
	public void deleteAppointment(String id) throws Exception {
		appointmentList.remove(searchForAppointment(id));
	}

	// get appointments form list
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	// search for appointments
	private Appointment searchForAppointment(String id) throws Exception {
		int index = 0;
		while (index < appointmentList.size()) {
			if (id.equals(appointmentList.get(index).getAppointmentId())) {
				return appointmentList.get(index);
			}
			index++;
		}
		throw new Exception("The appointment does not exist!");
	}
}
