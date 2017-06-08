package com.ap.model.users.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="api/Student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudenti(){
		List<Student> student = studentService.findAll();
		return new ResponseEntity<>(student, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){
		Student Student = studentService.findOne(id);
		if(Student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(Student, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Student> saveStudent(@RequestBody Student Student){
		
		
	
		Student = studentService.save(Student);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Student> updateStudent(@RequestBody Student Student){
		//a Student must exist
		
		if (Student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		Student = studentService.save(Student);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKurs(@RequestParam("id") Long id){
		Student Student = studentService.findOne(id);
		if (Student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
