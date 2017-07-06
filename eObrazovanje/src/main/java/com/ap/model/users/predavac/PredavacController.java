package com.ap.model.users.predavac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.model.users.student.Student;
import com.ap.web.dto.PredavacDTO;
import com.ap.web.dto.StudentDTO;

@RestController
@RequestMapping(value="api/predavac")
public class PredavacController {
	
	@Autowired
	PredavacService predavacService;
	
	@RequestMapping(value="/findByUsername", method = RequestMethod.GET)
	public ResponseEntity<PredavacDTO> getUser(@RequestParam("username") String username) {
        try {
		    Predavac predavac = predavacService.findByUserName(username);
		    PredavacDTO predavacDTO = new PredavacDTO(predavac);
		    
            return new ResponseEntity<PredavacDTO>(predavacDTO, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<PredavacDTO>( HttpStatus.BAD_REQUEST);
        }
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PredavacDTO>> getPredavaci(){
		List<Predavac> predavaci = predavacService.findAll();
		List<PredavacDTO> predavaciDTO = new ArrayList<>();
		for (Predavac p : predavaci) {
			predavaciDTO.add(new PredavacDTO(p));
		}
		return new ResponseEntity<>(predavaciDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredavac(@RequestParam("id") Long id){
		Predavac predavac = predavacService.findOne(id);
		if (predavac != null){
			predavacService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Void> saveStudent(@RequestBody Predavac predavac){
			
	
//		Student = studentService.save(Student);
		predavacService.save(predavac);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}

}
