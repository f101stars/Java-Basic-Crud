package Adv.models;


import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table
public class AdvTime extends baseAdv{
	@Column
	private int desiredMinutes;

	@Column
	private LocalDate timeStart;

	public int getDesiredMinutes() {
		return desiredMinutes;
	}

	public void setDesiredMinutes(int desiredMinutes) {
		this.desiredMinutes = desiredMinutes;
	}

	public LocalDate getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalDate timeStart) {
		this.timeStart = timeStart;
	}
}
