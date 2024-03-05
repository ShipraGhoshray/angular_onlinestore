package com.onlinestore.onlinestore.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.onlinestore.onlinestore.repository.User;
import com.onlinestore.onlinestore.repository.UserRepository;
import com.onlinestore.onlinestore.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> lookup(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id){
    	return userRepository.findById(id);
    }
    
    @Override
    public long total() {
        return userRepository.count();
    }

	@Override
	public User createUser(long userId, String userType, String firstName, String lastName, String emailId, long phoneNumber) {
        return userRepository.findById(userId).orElse(
        		userRepository.save(new User(userId, userType, firstName, lastName, emailId, phoneNumber)));   
	}

	@Override
	public void delete(User user){
		userRepository.delete(user);
	}
}

