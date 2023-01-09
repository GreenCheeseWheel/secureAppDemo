package ar.com.security.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((req) -> req.requestMatchers("/hello").hasRole("USER")
				.requestMatchers("/systems").hasRole("ADMIN")
				.requestMatchers("/", "/home").permitAll().anyRequest().authenticated()
				)
			.formLogin((form) -> form.loginPage("/login").permitAll())
			.logout((lgout) -> lgout.permitAll());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails normalUser = User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.roles("USER")
				.build();
		
		UserDetails normalAdmin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(normalUser, normalAdmin);
	}
	
}
