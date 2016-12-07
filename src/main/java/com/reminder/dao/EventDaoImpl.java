package com.reminder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reminder.model.Event;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Event> getAllEvents() {
		Session session = sessionFactory.openSession();
		List<Event> events = session.createQuery("from Event").list();
		System.out.println("----List of Events-----");
		System.out.println(events);
		session.flush();
		session.close();
		return events;
	}

	@Transactional
	public Event getEventById(String eventId) {
		Session session = sessionFactory.openSession();
		Event event = (Event) session.get(Event.class, eventId);
		System.out.println("----getEventById : " + event);
		session.close();
		return event;
	}

	@Transactional
	public boolean saveEvent(Event event) {
		Session session = sessionFactory.openSession();
		try {
			session.save(event);
			System.out.println("-----Saving Event---" + event);
			session.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Event updateEvent(String eventId, Event event) {
		System.out.println("-----Starting update event in daoimpl");
		Session session = sessionFactory.openSession();

		Event currentEvent = (Event) session.get(Event.class, eventId);
		if (currentEvent == null)
			return null;
		session.merge(event);
		Event updatedevent = (Event) session.get(Event.class, eventId);
		session.flush();
		session.close();
		System.out.println("Ending Update method in DaoImpl");
		return updatedevent;
	}

	@Transactional
	public boolean removeEvent(String eventId) {
		Session session = sessionFactory.openSession();
		// make the object persistent - Event
		try {
			Event event = (Event) session.get(Event.class, eventId);
			session.delete(event);
			// Transient - Event
			System.out.println("-----Removing------" + event);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}