package com.ap.model.kurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.model.users.student.Student;
import com.ap.web.dto.KursDTO;
import com.ap.web.dto.PohadjanjeDTO;


@RestController
@RequestMapping(value="api/kurs")
public class KursController {

	@Autowired
	KursService kursService;
	
  
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Kurs>> getKursevi(){
		List<Kurs> knjige = kursService.findAll();
		return new ResponseEntity<>(knjige, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KursDTO> getKurs(@PathVariable Long id){
		Kurs Kurs = kursService.findOne(id);
		if(Kurs == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new KursDTO(Kurs), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Kurs> saveKurs(@RequestBody Kurs Kurs){
		
		
	
		Kurs = kursService.save(Kurs);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Kurs> updateKurs(@RequestBody Kurs Kurs){
		//a Kurs must exist
		
		if (Kurs == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		Kurs = kursService.save(Kurs);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE ,value="/{id}")
	public ResponseEntity<List<KursDTO>> deleteKurs(@PathVariable Long id){
		Kurs Kurs = kursService.findOne(id);
		if (Kurs != null){
			kursService.remove(id);
			List<Kurs> kursevi = kursService.findAll();
			List<KursDTO> kursDTOs = new ArrayList<>();
			for (Kurs kurs2 : kursevi) {
				kursDTOs.add(new KursDTO(kurs2));
			}
			return new ResponseEntity<>(kursDTOs,HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
