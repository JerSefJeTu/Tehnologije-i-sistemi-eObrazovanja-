package com.ap.model.uplata;

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
@RequestMapping(value="api/Uplata")
public class UplataController {
	
	@Autowired
	UplataService uplataService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Uplata>> getUplata(){
		List<Uplata> uplata = uplataService.findAll();
		return new ResponseEntity<>(uplata, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public ResponseEntity<Uplata> getUplata(@RequestParam("id") Long id){
		Uplata Uplata = uplataService.findOne(id);
		if(Uplata == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(Uplata, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Uplata> saveUplata(@RequestBody Uplata Uplata){
		
		
	
		Uplata = uplataService.save(Uplata);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Uplata> updateUplata(@RequestBody Uplata Uplata){
		//a Uplata must exist
		
		if (Uplata == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		Uplata = uplataService.save(Uplata);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUplata(@RequestParam("id") Long id){
		Uplata Uplata = uplataService.findOne(id);
		if (Uplata != null){
			uplataService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
