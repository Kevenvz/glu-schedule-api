package com.github.kevenvz.timetable.config;

import com.github.kevenvz.timetable.social.Google;
import com.github.kevenvz.timetable.social.GoogleConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        GoogleConnectionFactory googleConnectionFactory = new GoogleConnectionFactory(environment.getProperty("spring.social.google.app-id"), environment.getProperty("spring.social.google.app-secret"));
        googleConnectionFactory.setScope(environment.getProperty("spring.social.google.app-scope"));
        connectionFactoryConfigurer.addConnectionFactory(googleConnectionFactory);
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Google google(ConnectionRepository repository) {
        Connection<Google> connection = repository.findPrimaryConnection(Google.class);
        return connection != null ? connection.getApi() : null;
    }
}
