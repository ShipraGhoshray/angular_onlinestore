package com.onlinestore.onlinestore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.onlinestore.onlinestore.service.impl.UserServiceImpl;
import com.onlinestore.onlinestore.util.Constants;

@SpringBootApplication
public class OnlineStoreApplication implements CommandLineRunner{

	private UserServiceImpl userService;
    public OnlineStoreApplication(UserServiceImpl userService) {
    	this.userService = userService;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		createUser();
		long userCount = userService.total();
		System.out.println("Total users in the system is : "+ userCount);
	}
	
	private void createUser() {
		userService.createUser(1L, Constants.USER_TYPE_ADMIN, "Joey", "Tribiani", "Joey.Tribiani@gmail.com", 971565678901L);
		userService.createUser(2L, Constants.USER_TYPE_CUSTOMER, "Rachel", "Green", "Rachel.Green@gmail.com", 971566789012L);
		userService.createUser(3L, Constants.USER_TYPE_CUSTOMER, "Ross", "Gellar", "Ross.Gellar@gmail.com", 971567890123L);
		userService.createUser(4L, Constants.USER_TYPE_CUSTOMER, "Monica",	"Gellar", "Monica.Gellar@gmail.com", 971568901234L);
		userService.createUser(5L, Constants.USER_TYPE_CUSTOMER, "Chandler", "Bing", "Chandler.Bing@gmail.com", 971560123456L);
	}
}
