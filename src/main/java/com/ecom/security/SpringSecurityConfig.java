package com.ecom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		super.configure(auth);
		auth
		.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN").and();
		auth
		.inMemoryAuthentication()
			.withUser("mohamed").password("mohamed").roles("ADMIN").and();
	      	auth.inMemoryAuthentication().withUser("ad").password("ad").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//super.configure(http);
		http
			.authorizeRequests()	
				.antMatchers("/admin/all/**").fullyAuthenticated().and().httpBasic();	
	}
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}
	
}