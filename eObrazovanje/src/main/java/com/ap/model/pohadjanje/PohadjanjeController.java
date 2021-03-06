package com.ap.model.pohadjanje;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.polaganjeIspita.PolaganjeIspitaService;
import com.ap.model.predispitnaObaveza.PredispitnaObaveza;
import com.ap.model.predispitnaObaveza.PredispitnaObavezaService;
import com.ap.model.users.student.Student;
import com.ap.model.users.student.StudentService;
import com.ap.web.dto.PohadjanjeDTO;



@RestController
@RequestMapping(value="api/pohadjanje")
public class PohadjanjeController {
	
	@Autowired
	PohadjanjeService pohadjanjeService;
	@Autowired
	KursService kursService;
	@Autowired
	StudentService studentService;
	@Autowired
	PredispitnaObavezaService predispitnaObavezaService;
	@Autowired
	PolaganjeIspitaService polaganjeIspitaService;
	
	@RequestMapping(method=RequestMethod.GET, 
		      params = { "page", "size" })
	public ResponseEntity<Page<PohadjanjeDTO>> getKursevi(@RequestParam("page") int page, @RequestParam("size") int size){
		List<Pohadjanje> pohadjanja = pohadjanjeService.findAll();
		List<PohadjanjeDTO> pohadjanjeDTO = new ArrayList<>();
		for(Pohadjanje p : pohadjanja) {
			pohadjanjeDTO.add(new PohadjanjeDTO(p));
		}
		Page<PohadjanjeDTO> pages = 
				new PageImpl<>(pohadjanjeDTO, new PageRequest(page, size), pohadjanjeDTO.size());
		return new ResponseEntity<>(pages, HttpStatus.OK);
		
	}
	
	/*@RequestMapping(method = RequestMethod.GET,  value="/student",
			params = {"id"})
	public ResponseEntity<String> getPohadjanjeByStudent(@RequestParam("id") long id) {
		
	}*/
	
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
	
	@RequestMapping(value="/findByKurs/{idKursa}" ,method=RequestMethod.GET)
	public ResponseEntity<List<PohadjanjeDTO>> getPohadjanjabyKurs(@PathVariable Long idKursa){
		Kurs kurs = kursService.findOne(idKursa);
		List<Pohadjanje> pohadjanja = pohadjanjeService.findByKurs(kurs);
		List<PohadjanjeDTO> pohadjanjeDTOs = new ArrayList<>();
		for (Pohadjanje pohadjanje : pohadjanja) {
			pohadjanjeDTOs.add(new PohadjanjeDTO(pohadjanje));
		}
		
		return new ResponseEntity<>(pohadjanjeDTOs, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/findByStudent/{idStudenta}", method=RequestMethod.GET,
			params={"page", "size"})
	public ResponseEntity<Page<PohadjanjeDTO>> getPohadjanjaByStudent(@PathVariable("idStudenta") Long idStudenta,
			@RequestParam("page") int page, @RequestParam("size") int size) {
		Student student = studentService.findOne(idStudenta);
		List<Pohadjanje> pohadjanja = pohadjanjeService.findByStudent(student);
		List<PohadjanjeDTO> pohadjanjaDTO = new ArrayList<>();
		for(Pohadjanje pohadjanje : pohadjanja) {
			pohadjanjaDTO.add(new PohadjanjeDTO(pohadjanje));
		}
		Page<PohadjanjeDTO> pages = 
				new PageImpl<>(pohadjanjaDTO, new PageRequest(page, size), pohadjanjaDTO.size());
		return new ResponseEntity<>(pages, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByStudent/{idStudenta}", method=RequestMethod.GET)
	public ResponseEntity<List<PohadjanjeDTO>> getPohadjanjaByStudentID(@PathVariable("idStudenta") Long idStudenta) {
		Student student = studentService.findOne(idStudenta);
		List<Pohadjanje> pohadjanja = pohadjanjeService.findByStudent(student);
		List<PohadjanjeDTO> pohadjanjaDTO = new ArrayList<>();
		for(Pohadjanje pohadjanje : pohadjanja) {
			pohadjanjaDTO.add(new PohadjanjeDTO(pohadjanje));
		}
		
		return new ResponseEntity<>(pohadjanjaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/many", method=RequestMethod.POST ,consumes="application/json")
	public ResponseEntity<Pohadjanje> getMany(@RequestBody ArrayList<Pohadjanje> pohadjanja) {
		Kurs kurs = pohadjanja.get(0).getKurs();
		List<PredispitnaObaveza> predispitnaObavezaKursa=predispitnaObavezaService.findByKurs(kurs);
		Set<PredispitnaObaveza> predispitne = new HashSet<PredispitnaObaveza>(predispitnaObavezaKursa);
		
		
		for (Pohadjanje pohadjanje : pohadjanja) {
			PolaganjeIspita polaganjeIspita = new PolaganjeIspita();
			polaganjeIspita.setPredispitneObaveze(predispitne);
			polaganjeIspitaService.save(polaganjeIspita);
			pohadjanje.setPolaganje(polaganjeIspita);
			pohadjanjeService.save(pohadjanje);
			for (PredispitnaObaveza predispitnaObaveza : predispitne) {
				PredispitnaObaveza kopijaPredispitnaObaveza = new PredispitnaObaveza(predispitnaObaveza);
				kopijaPredispitnaObaveza.setPolaganjeIspita(polaganjeIspita);
				predispitnaObavezaService.save(kopijaPredispitnaObaveza);
				
			}
	
		}
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
}
