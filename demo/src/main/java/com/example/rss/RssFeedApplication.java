package com.example.rss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Boot launcher for an application which exposes an RSS Feed.
 * 
 
 *
 */
@SpringBootApplication
@ComponentScan({"com.example"})
public class RssFeedApplication {

	/**
	 * Launches a Spring Boot application which exposes an RSS Feed.
	 * 
	 * @param args null
	 */
    public static void main(final String[] args) {
        SpringApplication.run(RssFeedApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }
}