package com.reminder.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.model.Event;
import com.reminder.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private Event event;

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	@RequestMapping(value = "/event/getMyEvents", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> getAllEvents(HttpSession session) {
		System.out.println("----Starting getAllEvents in EventController");
		String loggedInUser = (String) session.getAttribute("loggedInUserId");
		List<Event> events = eventService.getMyEvents(loggedInUser);
		if (events.isEmpty()) {
			event.setErrorCode("404");
			event.setErrorMessage("No event available");
			events.add(event);
		}
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}

	@RequestMapping(value = "/event/getEventById/{eventId}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEventById(@PathVariable("eventId") int eventId) {
		System.out.println("----Starting getBId in EventController----");
		Event event = eventService.getEventById(eventId);
		if (event == null) {
			event = new Event();
			event.setErrorCode("404"); // NLP NullPointerException
			event.setErrorMessage("User does not exist with this id:" + eventId);
			return new ResponseEntity<Event>(event, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@RequestMapping(value = "/event/addEvent/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveEvent(@RequestBody Event event, HttpSession session) {
		System.out.println("---Saving Events---");
		String loggedInUser = (String) session.getAttribute("loggedInUserId");
		Date date = new Date();
		event.setEventCreatedDate(date.toString());
		event.setUserId(loggedInUser);
		eventService.saveEvent(event);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/event/deleteEvent/{eventId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEvent(@PathVariable("eventId") int eventId) {
		System.out.println("----Starting delete in Eventcontroller");
		Event event = eventService.getEventById(eventId);
		if (event == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		eventService.removeEvent(eventId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/event/updateEvent/{eventId}", method = RequestMethod.PUT)
	public ResponseEntity<Event> updateEvent(@PathVariable("eventId") int eventId, @RequestBody Event event) {
		Date date = new Date();
		event.setEventCreatedDate(date.toString());
		Event updatedEvent = eventService.updateEvent(eventId, event);
		event.setErrorCode("200");
		event.setErrorMessage("Updated Successfully");
		return new ResponseEntity<Event>(updatedEvent, HttpStatus.OK);

	}

}
