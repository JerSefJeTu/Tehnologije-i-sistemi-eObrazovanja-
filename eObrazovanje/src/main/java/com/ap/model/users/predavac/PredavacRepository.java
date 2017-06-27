package com.ap.model.users.predavac;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.model.users.student.Student;

public interface PredavacRepository  extends JpaRepository<Predavac, Long>{

	
	public Predavac findByUserName(String username);
}
