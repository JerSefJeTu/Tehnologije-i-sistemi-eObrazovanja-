package com.ap.model.uplata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.model.users.student.Student;

public interface UplataRepository extends JpaRepository<Uplata, Long> {
	
	public List<Uplata> findByStudent(Student student);

}
