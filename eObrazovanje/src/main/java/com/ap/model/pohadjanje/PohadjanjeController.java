package com.ap.model.pohadjanje;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.ap.web.dto.PohadjanjeDTO;





@RestController
@RequestMapping(value="api/pohadjanje")
public class PohadjanjeController {
	
	@Autowired
	PohadjanjeService pohadjanjeService;
	@Autowired
	KursService kursService;
	
	@RequestMapping(method=RequestMethod.GET, 
		      params = { "page", "size" })
	public ResponseEntity<Page<Pohadjanje>> getKursevi(@RequestParam("page") int page, @RequestParam("size") int size){
		
		 Page<Pohadjanje> resultPage = pohadjanjeService.findPaginated(page, size);
		return new ResponseEntity<>(resultPage, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pohadjanje> getKurs(@PathVariable Long id){
		Pohadjanje Pohadjanje = pohadjanjeService.findOne(id);
		if(Pohadjanje == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(Pohadjanje, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Pohadjanje> saveKurs(@RequestBody Pohadjanje Pohadjanje){
		
		
	
		Pohadjanje = pohadjanjeService.save(Pohadjanje);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Pohadjanje> updateKurs(@RequestBody Pohadjanje Pohadjanje){
		//a Pohadjanje must exist
		
		if (Pohadjanje == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	
		Pohadjanje = pohadjanjeService.save(Pohadjanje);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKurs(@RequestParam("id") Long id){
		Pohadjanje Pohadjanje = pohadjanjeService.findOne(id);
		if (Pohadjanje != null){
			pohadjanjeService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/findByKurs" ,method=RequestMethod.GET)
	public ResponseEntity<List<PohadjanjeDTO>> getPohadjanjabyKurs(@RequestParam("idKursa") Long idKursa){
		Kurs kurs = kursService.findOne(idKursa);
		List<Pohadjanje> pohadjanja = pohadjanjeService.findByKurs(kurs);
		List<PohadjanjeDTO> pohadjanjeDTOs = new ArrayList<>();
		for (Pohadjanje pohadjanje : pohadjanja) {
			pohadjanjeDTOs.add(new PohadjanjeDTO(pohadjanje));
		}
		return new ResponseEntity<>(pohadjanjeDTOs, HttpStatus.OK);
		
	}
	
}
