//
//package com.skylivings.webapp.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import com.skylivings.webapp.service.MyUserDetailsService;
//
//@EnableWebSecurity  
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//  
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//  @Override protected void configure(HttpSecurity http) throws Exception {
//	  				http. csrf().disable() 
//	  				.authorizeRequests()
//	  				.antMatchers("/", "/home","login").permitAll()
//	  				.antMatchers("/register-tenant").hasAuthority("MANAGER")
//	  				.anyRequest().authenticated() 
//	  				.and() 
//	  				.httpBasic();
//	  			}
//  
//  @Bean public AuthenticationManager authenticationManager() throws Exception {
//  return super.authenticationManager(); 
//  }
//  
//  
//  @Bean
//  AuthenticationProvider authenticationProvider(){  
//	  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	  provider.setUserDetailsService(userDetailsService);
//	  provider.setPasswordEncoder(new BCryptPasswordEncoder());
//	  return provider;
//  }
//  }
