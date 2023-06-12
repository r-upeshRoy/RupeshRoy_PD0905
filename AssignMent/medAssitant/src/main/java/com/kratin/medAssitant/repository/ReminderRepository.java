package com.kratin.medAssitant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratin.medAssitant.entities.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Long>{

}
