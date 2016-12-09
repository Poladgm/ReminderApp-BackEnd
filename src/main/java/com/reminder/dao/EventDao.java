package com.reminder.dao;

import java.util.List;

import com.reminder.model.Event;

public interface EventDao {

	List<Event> getMyEvents(String userId);
	
	Event getEventById(int eventId);
	
	boolean saveEvent(Event event);
	
	Event updateEvent(int eventId,Event event);
	
	boolean removeEvent(int eventId);
}
