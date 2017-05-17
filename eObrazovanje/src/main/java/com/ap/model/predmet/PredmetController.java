package com.ap.model.predmet;

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
@RequestMapping(value="api/Predmet")
public class PredmetController {
	
	@Autowired
	PredmetService predmetService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Predmet>> getKursevi(){
		List<Predmet> pohadjanja = predmetService.findAll();
		return new ResponseEntity<>(pohadjanja, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public ResponseEntity<Predmet> getKurs(@RequestParam("id") Long id){
		Predmet Predmet = predmetService.findOne(id);
		if(Predmet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(Predmet, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Predmet> saveKurs(@RequestBody Predmet Predmet){
		
		
	
		Predmet = predmetService.save(Predmet);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Predmet> updateKurs(@RequestBody Predmet Predmet){
		//a Predmet must exist
		
		if (Predmet == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		Predmet = predmetService.save(Predmet);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKurs(@RequestParam("id") Long id){
		Predmet Predmet = predmetService.findOne(id);
		if (Predmet != null){
			predmetService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
