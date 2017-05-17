package com.ap.model.polaganjeIspita;

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
@RequestMapping(value="api/PolaganjeIspita")
public class PolaganjeIspitaController {
	
	@Autowired
	PolaganjeIspitaService polaganjeIspitaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PolaganjeIspita>> getKursevi(){
		List<PolaganjeIspita> pohadjanja = polaganjeIspitaService.findAll();
		return new ResponseEntity<>(pohadjanja, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public ResponseEntity<PolaganjeIspita> getKurs(@RequestParam("id") Long id){
		PolaganjeIspita PolaganjeIspita = polaganjeIspitaService.findOne(id);
		if(PolaganjeIspita == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(PolaganjeIspita, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PolaganjeIspita> saveKurs(@RequestBody PolaganjeIspita PolaganjeIspita){
		
		
	
		PolaganjeIspita = polaganjeIspitaService.save(PolaganjeIspita);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PolaganjeIspita> updateKurs(@RequestBody PolaganjeIspita PolaganjeIspita){
		//a PolaganjeIspita must exist
		
		if (PolaganjeIspita == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		PolaganjeIspita = polaganjeIspitaService.save(PolaganjeIspita);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKurs(@RequestParam("id") Long id){
		PolaganjeIspita PolaganjeIspita = polaganjeIspitaService.findOne(id);
		if (PolaganjeIspita != null){
			polaganjeIspitaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
