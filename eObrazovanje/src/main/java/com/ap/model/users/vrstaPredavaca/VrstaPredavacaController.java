package com.ap.model.users.vrstaPredavaca;

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
@RequestMapping(value="api/VrstaPredavaca")
public class VrstaPredavacaController {
	
	@Autowired
	VrstaPredavacaService vrstaPredavacaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VrstaPredavaca>> getKursevi(){
		List<VrstaPredavaca> pohadjanja = vrstaPredavacaService.findAll();
		return new ResponseEntity<>(pohadjanja, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public ResponseEntity<VrstaPredavaca> getKurs(@RequestParam("id") Long id){
		VrstaPredavaca VrstaPredavaca = vrstaPredavacaService.findOne(id);
		if(VrstaPredavaca == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(VrstaPredavaca, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<VrstaPredavaca> saveKurs(@RequestBody VrstaPredavaca VrstaPredavaca){
		
		
	
		VrstaPredavaca = vrstaPredavacaService.save(VrstaPredavaca);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<VrstaPredavaca> updateKurs(@RequestBody VrstaPredavaca VrstaPredavaca){
		//a VrstaPredavaca must exist
		
		if (VrstaPredavaca == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		VrstaPredavaca = vrstaPredavacaService.save(VrstaPredavaca);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKurs(@RequestParam("id") Long id){
		VrstaPredavaca VrstaPredavaca = vrstaPredavacaService.findOne(id);
		if (VrstaPredavaca != null){
			vrstaPredavacaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
