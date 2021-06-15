package org.bank.sbi.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class BeanConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory getSessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
}
