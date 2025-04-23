package com.springsecurity.telusko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		
//		httpSecurity.csrf(customizer -> customizer.disable());
//		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//		//enable login form for browser
//		//httpSecurity.formLogin(Customizer.withDefaults());
//		//enable form login for rest clients
//		httpSecurity.httpBasic(Customizer.withDefaults());
//		httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
//		return httpSecurity.build();
		
		return httpSecurity
			.csrf(customizer -> customizer.disable())
			.authorizeHttpRequests(request -> request.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.build();
	}
	
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		
//		UserDetails user1 = User
//				.withDefaultPasswordEncoder()
//				.username("def")
//				.password("def")
//				.roles("USER")
//				.build();
//		
//		UserDetails user2 = User
//				.withDefaultPasswordEncoder()
//				.username("ghi")
//				.password("ghi")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1, user2);
//	}
	
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
}
