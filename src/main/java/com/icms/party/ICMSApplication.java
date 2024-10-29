package com.icms.party;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class ICMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICMSApplication.class, args);
	}

	/*
	 * @Bean Docket configureSwagger() { return new
	 * Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant(
	 * "/student/**")).build()
	 * 
	 * .apiInfo(new ApiInfo("Party API Documentation", "A Sample API for Parties",
	 * "1.0.0", "Party Management", new Contact("Nikhila",
	 * "www.nikhilacorporation.com", "nikhiladamaraju30@gmail.com"),
	 * "Standard API License", "www.nikhila.com", Collections.emptyList()));
	 * 
	 * }
	 */

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	  @Bean
	    public BCryptPasswordEncoder encoder(){
	    	BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
	        return passwordEncoder;
	    }

}
