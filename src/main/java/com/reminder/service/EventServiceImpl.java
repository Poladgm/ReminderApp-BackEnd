package com.reminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reminder.dao.EventDao;
import com.reminder.model.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return eventDao.getAllEvents();
	}

	public Event getEventById(String eventId) {
		// TODO Auto-generated method stub
		return eventDao.getEventById(eventId);
	}

	public boolean saveEvent(Event event) {
		// TODO Auto-generated method stub
		return eventDao.saveEvent(event);
	}

	public Event updateEvent(String eventId, Event event) {
		// TODO Auto-generated method stub
		return eventDao.updateEvent(eventId, event);
	}

	public boolean removeEvent(String eventId) {
		// TODO Auto-generated method stub
		return eventDao.removeEvent(eventId);
	}

}