package com.onlinestore.onlinestore.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.onlinestore.onlinestore.repository.User;

@Service
public interface UserService{

	public User createUser(long userId, String userType, String firstName, String lastName, String emailId, long phoneNumber);
	public Iterable<User> lookup();
	public Optional<User> findById(long userId);
	public long total();
	public void delete(User user);
}
