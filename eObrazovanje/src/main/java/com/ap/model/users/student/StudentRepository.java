package com.ap.model.users.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public Student findByUserName(String username);
	
}
