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
@Table(name = "diseases") 
public class Disease {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long d_Id;
	
	@Column(name = "d_Name", nullable = false)
	private String diseaseName;
	
	@Column(name = "d_Description")
	private String diseaseDescription;
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private User diseaseUser;
	
	@OneToMany(mappedBy = "medDisease", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Medicine> medicines = new ArrayList<Medicine>();    //init empty list
	
	public void addMedicine(Medicine medicine) {
		medicines.add(medicine);
		medicine.setMedDisease(this);
	}
	
	
	
}
