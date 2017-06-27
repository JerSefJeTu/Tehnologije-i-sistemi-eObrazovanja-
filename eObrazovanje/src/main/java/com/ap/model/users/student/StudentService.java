package com.ap.model.users.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student findOne(Long id) {
		return studentRepository.findOne(id);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student save(Student Student) {
		return studentRepository.save(Student);
	}

	public void remove(Long id) {
		studentRepository.delete(id);
	}
	
	public Student findByUserName(String username) {
		return studentRepository.findByUserName(username);
	}
}
