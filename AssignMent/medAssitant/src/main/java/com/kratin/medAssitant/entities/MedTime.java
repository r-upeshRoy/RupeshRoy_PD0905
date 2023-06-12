package com.kratin.medAssitant.entities;

import java.time.LocalDateTime;

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
@Table(name = "med_time")
public class MedTime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long t_Id;

	@Column(name = "date_time")
    private LocalDateTime dateTime;
	
	
	@JoinColumn(name = "medicine_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Medicine timeMedicine;
	
	
	
}
