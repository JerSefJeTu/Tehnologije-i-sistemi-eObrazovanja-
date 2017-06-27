package com.ap.model.users.predavac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
