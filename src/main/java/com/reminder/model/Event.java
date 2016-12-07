package com.reminder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Event extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String eventId;
	private String title;
	private String description;
	private String eventCreatedDate;
	private String deadLine;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventCreatedDate() {
		return eventCreatedDate;
	}

	public void setEventCreatedDate(String eventCreatedDate) {
		this.eventCreatedDate = eventCreatedDate;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

}
