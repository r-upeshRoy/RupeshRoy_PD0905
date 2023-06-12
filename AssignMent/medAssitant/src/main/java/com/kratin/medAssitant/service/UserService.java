package com.kratin.medAssitant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratin.medAssitant.entities.Disease;
import com.kratin.medAssitant.entities.Medicine;
import com.kratin.medAssitant.entities.Reminder;
import com.kratin.medAssitant.entities.User;
import com.kratin.medAssitant.repository.DiseaseRepository;
import com.kratin.medAssitant.repository.ReminderRepository;
import com.kratin.medAssitant.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DiseaseRepository diseaseRepository;
	
	@Autowired
	private ReminderRepository reminderRepository;
	
	//Method for creating Customer Account
	public String createUser(User user) {	
	
		userRepository.save(user);
	
		return "User addded Successfully";		
	}
	
	//Get All User 
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	
	// add disease to user
    public String addDisease(Long id, Disease disease) {
		User user=userRepository.findById(id).get();
		user.addDisease(disease);
		diseaseRepository.save(disease);		
		return "successfully Added User Disease";
	}
    
    
	// add reminder to user
    public String addReminder(Long id, Reminder reminder) {
		User user=userRepository.findById(id).get();
		user.addReminder(reminder);
		reminderRepository.save(reminder);		
		return "successfully Added reminder";
	}
    
    
 // delete user's reminder 
    public String deleteReminder(Long r_id) {
    
	    Reminder reminder =  reminderRepository.findById(r_id).orElseThrow(() -> new RuntimeException("reminder not found"));
	    reminderRepository.delete(reminder);
	    
		return "successfully deleted reminder";
	}
    
    // login by email
    
    public User loginByEmail(User user) {
    	User user1 = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElseThrow( () -> new RuntimeException(" invalid user"));
        return user1;
    }
    
    
    

    
    
}
