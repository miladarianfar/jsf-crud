package com.user.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.user.entity.User;

public class UserDao {

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	
	public List<User> getUsers() {
		
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User").getResultList();
		
		session.getTransaction().commit();
		
		return users;
	}
	
	public void addUser(User user) {
		
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
	}
	
	public User getUser(int id) {
		
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		
		session.getTransaction().commit();
		
		return user;
	}
	
	public void updateUser(User user) {
		
		session.beginTransaction();
		
		Query query = session.createQuery("update User u set " +
							"firstName = :firstName, " +
							"lastName = :lastName, " +
							"email = :email, " +
							"password = :password " +
							"where id = :id");
		
		query.setParameter("firstName", user.getFirstName());
		query.setParameter("lastName", user.getLastName());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		query.setParameter("id", user.getId());
		query.executeUpdate();
		
		session.getTransaction().commit();
	}
	
	public void deleteUser(int id) {
		
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		
		session.delete(user);
		
		session.getTransaction().commit();
	}
}













