package fr.afgj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Configuration
public class JacksonHibernate {
	
	@Bean
	public Module datatypeHibernateModule() {
	  return new Hibernate4Module();
	}
}
