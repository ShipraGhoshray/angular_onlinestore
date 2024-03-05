package com.onlinestore.onlinestore.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import com.onlinestore.onlinestore.repository.User;
import com.onlinestore.onlinestore.repository.UserRepository;

public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

	private final UserRepository userRepository;
	
	public AppStartupEvent(UserRepository userRepository) {
		this.userRepository = userRepository;
	} 
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<User> users = this.userRepository.findAll();
		users.forEach(System.out::println);
	}
}