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

	public List<Event> getMyEvents(String userId) {
		// TODO Auto-generated method stub
		return eventDao.getMyEvents(userId);
	}

	public List<Event> getCompletedEvents(String userId) {
		// TODO Auto-generated method stub
		return eventDao.getCompletedEvents(userId);
	}

	public List<Event> getUnCompletedEvents(String userId) {
		// TODO Auto-generated method stub
		return eventDao.getUnCompletedEvents(userId);
	}

	public Event getEventById(int eventId) {
		// TODO Auto-generated method stub
		return eventDao.getEventById(eventId);
	}

	public boolean saveEvent(Event event) {
		// TODO Auto-generated method stub
		return eventDao.saveEvent(event);
	}

	public void updateStatus(Event event) {
		// TODO Auto-generated method stub
		eventDao.updateStatus(event);
	}

	public Event updateEvent(int eventId, Event event) {
		// TODO Auto-generated method stub
		return eventDao.updateEvent(eventId, event);
	}

	public boolean removeEvent(int eventId) {
		// TODO Auto-generated method stub
		return eventDao.removeEvent(eventId);
	}

}
