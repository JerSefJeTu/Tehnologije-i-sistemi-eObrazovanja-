package com.ap.model.predispitnaObaveza;

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

import com.ap.model.kurs.Kurs;
import com.ap.model.kurs.KursService;
import com.ap.web.dto.PredsipitnaObavezaDTO;



@RestController
@RequestMapping(value="api/predispitnaObaveza")
public class PredispitnaObavezaController {
	
	@Autowired
	PredispitnaObavezaService predispitnaObavezaService;
	
	@Autowired
	KursService kursService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PredispitnaObaveza>> getKursevi(){
		List<PredispitnaObaveza> pohadjanja = predispitnaObavezaService.findAll();
		return new ResponseEntity<>(pohadjanja, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredispitnaObaveza> getKurs(@PathVariable Long id){
		PredispitnaObaveza PredispitnaObaveza = predispitnaObavezaService.findOne(id);
		if(PredispitnaObaveza == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(PredispitnaObaveza, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredispitnaObaveza> saveKurs(@RequestBody PredispitnaObaveza PredispitnaObaveza){
	
		PredispitnaObaveza = predispitnaObavezaService.save(PredispitnaObaveza);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredispitnaObaveza> updateKurs(@RequestBody PredispitnaObaveza PredispitnaObaveza){
		//a PredispitnaObaveza must exist
		
		if (PredispitnaObaveza == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		PredispitnaObaveza = predispitnaObavezaService.save(PredispitnaObaveza);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE ,value="/{id}")
	public ResponseEntity<Void> deleteKurs(@PathVariable Long id){
		PredispitnaObaveza PredispitnaObaveza = predispitnaObavezaService.findOne(id);
		if (PredispitnaObaveza != null){
			predispitnaObavezaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getPredispitneByKurs/{kursId}")
	public ResponseEntity<List<PredsipitnaObavezaDTO>> getPredispitneByKurs(@PathVariable Long kursId){
		Kurs kurs = kursService.findOne(kursId);
		List<PredispitnaObaveza> predispitne = predispitnaObavezaService.findByKurs(kurs);
		List<PredsipitnaObavezaDTO> predispitnaObavezaDTOs= new ArrayList<>();
		for (PredispitnaObaveza predispitnaObaveza : predispitne) {
			predispitnaObavezaDTOs.add(new PredsipitnaObavezaDTO(predispitnaObaveza));
		}
		
		return new ResponseEntity<>(predispitnaObavezaDTOs, HttpStatus.OK);
		
	}
	
}
