package com.gcu.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/* This is a configuration class for the Spring Boot Application */
public class ServletInitializer extends SpringBootServletInitializer {

	Logger logger = LogManager.getLogger(ServletInitializer.class);

	//Configures the Application to run on cloud services
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("entering configuration method");
		logger.info("exiting configuration method");
		return application.sources(SiteApplication.class);
	}

}
