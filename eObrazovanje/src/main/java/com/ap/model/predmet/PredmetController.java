package com.ap.model.predmet;

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

import com.ap.web.dto.PredmetDto;



@RestController
@RequestMapping(value="api/predmet")
public class PredmetController {
	
	@Autowired
	PredmetService predmetService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Predmet>> getPredmet(){
		List<Predmet> predmet = predmetService.findAll();
		return new ResponseEntity<>(predmet, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredmetDto> getPredmet(@PathVariable Long id){
		Predmet Predmet = predmetService.findOne(id);
		if(Predmet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PredmetDto(Predmet), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Predmet> savePredmet(@RequestBody Predmet Predmet){
		
		
	
		Predmet = predmetService.save(Predmet);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Predmet> updatePredmet(@RequestBody Predmet Predmet){
		//a Predmet must exist
		
		if (Predmet == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		Predmet = predmetService.save(Predmet);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredmet(@RequestParam("id") Long id){
		Predmet Predmet = predmetService.findOne(id);
		if (Predmet != null){
			predmetService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
