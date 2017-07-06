package com.ap.model.predispitnaObaveza;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ap.model.kurs.Kurs;
import com.ap.model.kurs.KursService;
import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.polaganjeIspita.PolaganjeIspitaService;
import com.ap.web.dto.PredsipitnaObavezaDTO;




@RestController
@RequestMapping(value="api/predispitnaObaveza")
public class PredispitnaObavezaController {
	
	@Autowired
	PredispitnaObavezaService predispitnaObavezaService;
	
	@Autowired
	KursService kursService;
	
	@Autowired
	PolaganjeIspitaService polaganjeIspitaService;
	
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
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<PredsipitnaObavezaDTO> updateKurs(@RequestBody PredsipitnaObavezaDTO predsipitnaObavezaDTO){
		//a course must exist
				PredispitnaObaveza predispitnaObaveza = predispitnaObavezaService.findOne(predsipitnaObavezaDTO.getId()); 
				if (predispitnaObaveza == null) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
				
				
				Double brojbodova =(Double) (predispitnaObaveza.getPolaganjeIspita().getBrojBodova()-predispitnaObaveza.getBrojBodova());
				 Double novibrBOdova = brojbodova + (Double) predsipitnaObavezaDTO.getBrojBodova();
				 PolaganjeIspita polaganjeIspita = predispitnaObaveza.getPolaganjeIspita();
				 polaganjeIspita.setBrojBodova(novibrBOdova);
				 polaganjeIspitaService.save(polaganjeIspita);
				 predispitnaObaveza.setBrojBodova(predsipitnaObavezaDTO.getBrojBodova());
				predispitnaObaveza = predispitnaObavezaService.save(predispitnaObaveza);
				return new ResponseEntity<>(new PredsipitnaObavezaDTO(predispitnaObaveza), HttpStatus.OK);	
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
