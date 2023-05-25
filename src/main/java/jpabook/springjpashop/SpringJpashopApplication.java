package jpabook.springjpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class})
public class SpringJpashopApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringJpashopApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurere(){
		return new WebMvcConfigurer(){
			private final long MAX_AGE_SECS = 3600;

			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOriginPatterns()
				.allowedOrigins("http://localhost:3000")
						// GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드를 허용한다.
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true)
						.maxAge(MAX_AGE_SECS);
			}
		};
	}
}
