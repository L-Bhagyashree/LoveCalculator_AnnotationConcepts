package com.Springmvc.lc.Config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.lang.Nullable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.Springmvc.lc.Formatter.PhoneNumberFormatter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.Springmvc")
public class LCAppConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}

	@Bean
	JdbcTemplate jdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/Project_Test?useSSL=false");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Smart@123");

		return dataSource;

	}

	// get details of where the error message file exist/ define the message source
	@Bean(name = "messageSource")
	public MessageSource messageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	// to show spring which file we are using to store our error messages ..Hey
	// spring for the validation please look for the messageSource
	// register message source
	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {

		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		System.out.println("Inside add formatter method");
		registry.addFormatter(new PhoneNumberFormatter());

	}

	// add the validator to webMvcConfigurer so that we can return the validator
	@Override
	public org.springframework.validation.Validator getValidator() {

		return validator();
	}

	@Bean
	public JavaMailSender configureJavaMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("deployreactproject@gmail.com");
		javaMailSenderImpl.setPassword("deployProject@123");
		javaMailSenderImpl.setPort(587);

		/*
		 * Properties mailProperties = new Properties(); //
		 * mailProperties.put("mail.smtp.starttls.enable", true); //
		 * mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		 * 
		 * javaMailSenderImpl.setJavaMailProperties(mailProperties);
		 */
		
		 Properties props = javaMailSenderImpl.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
		
		return javaMailSenderImpl;

	}

}
