package com.ap.model.uplata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.users.student.StudentService;
import com.ap.web.dto.PohadjanjeDTO;
import com.ap.web.dto.UplataDTO;



@RestController
@RequestMapping(value="api/uplata")
public class UplataController {
	
	@Autowired
	UplataService uplataService;
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Uplata>> getUplata(){
		List<Uplata> uplata = uplataService.findAll();
		return new ResponseEntity<>(uplata, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Uplata> getUplata(@PathVariable Long id){
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
	
	@RequestMapping(method=RequestMethod.GET,value="/findByStudent")
	public ResponseEntity<Map<String, ArrayList<UplataDTO>>> findByUser(@RequestParam("UserName")String userName){
		
		List<Uplata> uplate = uplataService.findByStudent(studentService.findByUserName(userName));
		
		List<UplataDTO> uplataDTOs = new ArrayList<>();
		for(Uplata uplata : uplate) {
			uplataDTOs.add(new UplataDTO(uplata));
		}
		
		Map<String, ArrayList<UplataDTO>> uplateMapa = new HashMap<>();
		uplateMapa.put("uplate", new ArrayList<>(uplataDTOs));
		return new ResponseEntity<>(uplateMapa, HttpStatus.OK);
		
	}
	
}
