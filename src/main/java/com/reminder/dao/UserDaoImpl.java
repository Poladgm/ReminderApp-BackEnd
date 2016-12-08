package com.reminder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reminder.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private User user;

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> getAllUsers() {
		System.out.println("Starting getAllUsers DaoImpl");
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Ending UserDao getAllUser");
		return query.list();
	}

	@Transactional
	public User getById(int id) {
		System.out.println("Starting of the getById method in DaoImpl");
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Transactional
	public boolean saveUser(User user) {
		System.out.println("starting save method in daoimpl");
		try {
			sessionFactory.openSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean updateUser(User user) {
		System.out.println("starting update method in daoimpl");
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public User validate(String emailId, String password) {
		System.out.println("Starting vlidate method in daoImpl");
		String hql = "from User where emailId='" + emailId + "' and password='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Ending of the Update Method in DaoImpl");
		return (User) query.uniqueResult();
	}

	public User getByemailId(String emailId) {
		System.out.println("Starting getby emailid method");
		String hql = "from User where emailId='" + emailId + "'";
		System.out.println("------getByemailID query : " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		return (User) query.uniqueResult();
	}

}
