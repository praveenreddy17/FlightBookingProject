package com.airlines.services.flight.booking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airlines.services.flight.booking.user.entity.FlightDetails;
import com.airlines.services.flight.booking.user.entity.User;
import com.airlines.services.flight.booking.user.entity.UserBookings;
import com.airlines.services.flight.booking.user.repository.UserRepository;
import com.airlines.services.flight.booking.user.service.UserService;


  

@Repository
@Transactional
public class UserDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory; 

	public ResponseEntity<User> createUser(User newUser) {
		// TODO Auto-generated method stub
		System.out.println("vinay"+sessionFactory.getEntityManagerFactoryName());
		System.out.println("vinay"+sessionFactory.getProperties());
		sessionFactory.getCurrentSession().saveOrUpdate(newUser);
		return new ResponseEntity<User>(newUser,HttpStatus.OK);
	}

	
	public User updateUser(User newUser)  {
		// TODO Auto-generated method stub
		System.out.println("vinay"+sessionFactory.getEntityManagerFactoryName());
		//System.out.println("vinay"+sessionFactory.getCurrentSession());
		sessionFactory.getCurrentSession().saveOrUpdate(newUser);
		return newUser;
	}

	
	public String deleteUser(int Id)  {
		// TODO Auto-generated method stub
	
		User student = sessionFactory.getCurrentSession().get(User.class, Id);		
		sessionFactory.getCurrentSession().delete(student);
		return null;
	}

	
	public List<UserBookings> getUserFlights(String ID) {
		// TODO Auto-generated method stub
		String hql="from UserBookings where UserName=:ID";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("ID", ID);
		return q.list();
	}

	

	
	public User getUser(int ID) {
		// TODO Auto-generated method stub
		String hql="from User where UserID=:ID";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("ID", ID);
		return (User) q.uniqueResult();
	}


	public void bookFlight(UserBookings booking) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(booking);
	}


	public User signIn(User user) {
		// TODO Auto-generated method stub
		String hql="from User where UserName=:userName and Password=:password";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("userName", user.getUserName());
		q.setParameter("password", user.getPassword());
		return (User) q.uniqueResult();
	}


	public List<FlightDetails> searchFlights(FlightDetails fDetails) {
		// TODO Auto-generated method stub
		String hql="from FlightDetails where FromPlace=:fromplace OR ToPlace=:fromplace or FromPlace=:toplace OR ToPlace=:toplace ";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("toplace", fDetails.getToPlace());
		q.setParameter("fromplace", fDetails.getFromPlace());
		return  q.list();
		
	}


	public User getUser(String userName) {
		// TODO Auto-generated method stub
		String hql="from User where UserName=:userName ";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("userName", userName);
		q.setMaxResults(1);
		return (User) q.list().get(0);
	}


	public void deleteUserFlight(int ID) {
		// TODO Auto-generated method stub
		String hql="delete UserBookings where ID=:ID ";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter("ID", ID);
		q.setMaxResults(1);
		q.executeUpdate();
	}

	

}
