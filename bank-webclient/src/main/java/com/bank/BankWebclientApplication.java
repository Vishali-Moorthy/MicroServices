package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableEurekaClient
public class BankWebclientApplication implements WebMvcConfigurer{
	
	public static final String USER_SERVICE_URL = "http://BankUserService";
	public static final String ACCOUNT_SERVICE_URL = "http://BankAccountService";
	

	public static void main(String[] args) {
		SpringApplication.run(BankWebclientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ClientUserService clientUserService(){
		return new RemoteUserRepository(USER_SERVICE_URL);
	}
	
	@Bean
	public ClientAccountService clientAccountService() {
		return new RemoteAccountRepository(ACCOUNT_SERVICE_URL);
	}

}
