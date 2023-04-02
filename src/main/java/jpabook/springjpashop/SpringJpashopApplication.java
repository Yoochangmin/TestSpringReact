package jpabook.springjpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringJpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpashopApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurere(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOriginPatterns();
			}
		};
	}
}
