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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "medicines") 
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long m_Id;
	
	@Column(name = "med_Name", nullable = false)
	private String medicineName;
	
	
	@JoinColumn(name = "disease_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Disease medDisease;
	
	@OneToMany(mappedBy = "timeMedicine", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<MedTime> medTimes = new ArrayList<MedTime>(); 
	
	public void addMedTime(MedTime medTime) {
		medTimes.add(medTime);
		medTime.setTimeMedicine(this);
	}
	
}
