package com.kratin.medAssitant.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
@Table(name = "users") 
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "user_name", nullable = false)
	private String name;
	
	@Column(name = "user_email", unique = true)
	private String email;
	
	@Column(name = "user_password", length=10 )
	private String password;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String mobileNumber;
	
	@OneToMany(mappedBy = "diseaseUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Disease> diseases = new ArrayList<Disease>();    //init empty list
	
	@OneToMany(mappedBy = "reminderUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Reminder> reminders = new ArrayList<Reminder>();    //init empty list
	
	
	public void addDisease(Disease disease) {
		diseases.add(disease);
		disease.setDiseaseUser(this);
	}
	
	public void addReminder(Reminder reminder) {
		reminders.add(reminder);
		reminder.setReminderUser(this);
	}
	
	
	public void deleteReminder(Reminder reminder) {
		reminders.remove(reminder);
		reminder.setReminderUser(null);
	}
	
	
	
	
	
	
	

}
