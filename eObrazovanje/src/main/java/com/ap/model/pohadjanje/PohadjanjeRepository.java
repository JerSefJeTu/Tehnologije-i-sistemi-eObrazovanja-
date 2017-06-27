package com.ap.model.pohadjanje;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.model.kurs.Kurs;
import com.ap.model.users.student.Student;

public interface PohadjanjeRepository extends JpaRepository<Pohadjanje, Long> {
	
	public List<Pohadjanje> findByKurs(Kurs kurs);
	
	public List<Pohadjanje> findByStudent(Student student);
	

}
