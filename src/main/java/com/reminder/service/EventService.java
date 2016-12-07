package com.reminder.service;

import java.util.List;

import com.reminder.model.Event;

public interface EventService {

	List<Event> getAllEvents();

	Event getEventById(String eventId);

	boolean saveEvent(Event event);

	Event updateEvent(String eventId, Event event);

	boolean removeEvent(String eventId);
}