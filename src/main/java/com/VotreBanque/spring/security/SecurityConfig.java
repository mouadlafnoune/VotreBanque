package com.VotreBanque.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.core.userdetails.User;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		@SuppressWarnings("deprecation")
//		  UserBuilder users = User.withDefaultPasswordEncoder();
//		  
//		  auth.inMemoryAuthentication()
//		  .withUser(users.username("admin").password("1234").roles("USER","ADMIN"))
//		  .withUser(users.username("user").password("1234").roles("USER"));
		
		auth.jdbcAuthentication().dataSource(dataSource)
		    .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
		    .authoritiesByUsernameQuery("select username as principal, roles as role from users_roles where username=?")
		    .rolePrefix("ROLE_")
		    .passwordEncoder(new Md4PasswordEncoder());
		 

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
