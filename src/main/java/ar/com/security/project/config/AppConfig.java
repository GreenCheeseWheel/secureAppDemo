package ar.com.security.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class AppConfig {

	@Bean
	public ViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver res = new InternalResourceViewResolver();
		res.setPrefix("/resources/templates/");
		res.setSuffix(".html");
		
		return res;
	}
	
}
