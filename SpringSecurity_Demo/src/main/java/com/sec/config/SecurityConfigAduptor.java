package com.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigAduptor extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("abc123").roles("ADMIN");

		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests()

				.antMatchers("/").hasAnyRole("ADMIN", "USER").antMatchers("/swagger-ui.html")
				.hasAnyRole("ADMIN", "USER")

				// User Api
				.antMatchers(HttpMethod.POST, "/user/**").hasRole("ADMIN").antMatchers(HttpMethod.GET, "/user/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.PATCH, "/user/status/{id}/{active}").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/user/password/{id}/{password}").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/user/**").hasRole("ADMIN")

				// products API

				.antMatchers(HttpMethod.POST, "/product/**").hasRole("ADMIN").antMatchers(HttpMethod.GET, "/product/**")
				.hasAnyRole("ADMIN", "USER")

				// Customer API
				.antMatchers(HttpMethod.POST, "/customer/**").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/customer/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/customer/**").hasAnyRole("USER")

				// Item API
				.antMatchers(HttpMethod.POST, "/item/**").hasRole("ADMIN").antMatchers(HttpMethod.GET, "/item/**")
				.hasAnyRole("ADMIN", "USER")

				.and().formLogin();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		
//	}
		

}
