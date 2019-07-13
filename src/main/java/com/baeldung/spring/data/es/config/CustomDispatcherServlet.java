/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baeldung.spring.data.es.config;

/**
 *
 * @author User
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class CustomDispatcherServlet implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();

        dispatcherServletContext.register(CustomDispatcherConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);

        // Create a servlet dynamically.
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", dispatcherServlet);

        dispatcher.setLoadOnStartup(1);

        // Add servlet mapping url. All url end with .html will be processed by this servlet.
        dispatcher.addMapping("*.html");
    }

}
