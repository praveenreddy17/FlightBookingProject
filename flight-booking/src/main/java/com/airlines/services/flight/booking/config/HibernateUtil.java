package com.airlines.services.flight.booking.config;



import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class HibernateUtil {

	/*@Autowired
	private EntityManagerFactory factory;

	@Bean
	public SessionFactory getSessionFactory() {
	    if (factory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return factory.unwrap(SessionFactory.class);
	}*/

}
