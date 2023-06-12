package com.kratin.medAssitant.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "reminder") 
public class Reminder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long r_Id;

	@Column(name = "taskName")
	private String taskName;
	
	
	@Column(name = "duration")
	private LocalTime duration;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "u_id")
	@JsonBackReference
	private User reminderUser;
	

	
}
