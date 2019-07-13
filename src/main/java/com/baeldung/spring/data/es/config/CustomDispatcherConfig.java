/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baeldung.spring.data.es.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com")
public class CustomDispatcherConfig extends WebMvcConfigurerAdapter {

    public static final String ENCODING_UTF = "UTF";

    public static final String ENCODING_UTF_8 = "UTF-8";

    public static final long MAX_UPLOAD_FILE_SIZE = 52428807;

    public static final long MAX_UPLOAD_PER_FILE_SIZE = 5242880;

    /* This configuration will use InternalResourceViewResolver to resolve jsp pages back to client user.
     * All the pages will be located in src/main/webapp/pages.
     *  */
    @Bean
    public InternalResourceViewResolver getJspViewResolver() {

        InternalResourceViewResolver ret = new InternalResourceViewResolver();

        ret.setPrefix("/pages/");

        ret.setSuffix(".jsp");

        ret.setOrder(1);

        return ret;

    }


    /* messageSource method name can not be change to others, else there will has errors when browse web page.
     * messageSource is used to make page text internalization. The message file is saved in src/main/resources/config/messages_en_US.preoperties
     * You should create config folder by yourself if it dose not exist.
     * */
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();

        ret.setBasename("classpath:config/messages_en_US");

        ret.setCacheSeconds(1);

        ret.setUseCodeAsDefaultMessage(true);

        ret.setDefaultEncoding(ENCODING_UTF);

        return ret;
    }

 
}
