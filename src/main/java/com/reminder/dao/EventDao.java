package com.reminder.dao;

import java.util.List;

import com.reminder.model.Event;

public interface EventDao {

	List<Event> getMyEvents(String userId);
	
	Event getEventById(String eventId);
	
	boolean saveEvent(Event event);
	
	Event updateEvent(String eventId,Event event);
	
	boolean removeEvent(String eventId);
}
