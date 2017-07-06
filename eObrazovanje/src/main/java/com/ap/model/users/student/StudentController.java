package com.ap.model.users.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ap.model.dokument.Dokument;
import com.ap.model.dokument.DokumentService;
import com.ap.model.users.korisnik.Korisnik;
import com.ap.web.dto.DokumentDTO;
import com.ap.web.dto.StudentDTO;





@RestController
@RequestMapping(value="api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	DokumentService dokumentService;
	
	  private static final String filePath = "downloads\\";
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudenti(){
		List<Student> studenti = studentService.findAll();
		List<StudentDTO> studentDTOs = new ArrayList<>();
		for (Student student : studenti) {
			studentDTOs.add(new StudentDTO(student));
		}
		return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
		Student Student = studentService.findOne(id);
		StudentDTO studentDTO = new StudentDTO(Student);
		if(studentDTO == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}

	
	@RequestMapping(value="/findByUsername", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getUser(@RequestParam("username") String username) {
        try {
		    Student student = studentService.findByUserName(username);
		    StudentDTO studentDTO = new StudentDTO(student);
		    
            return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<StudentDTO>( HttpStatus.BAD_REQUEST);
        }
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Student> saveStudent(@RequestBody Student Student){
			
	
//		Student = studentService.save(Student);
		studentService.save(Student);
		return new ResponseEntity<>( HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<Student> updateStudent(@RequestBody StudentDTO Student){
		//a Student must exist
		
		if (Student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Student student=studentService.findOne(Student.getId());
		student.setUserName(Student.getUsername());
		student.setUplate(Student.getUplate());
		student.setStanje(Student.getStanje());
		student.setPlaceOfOrigin(Student.getPlaceOfOrigin());
		student.setPhoneNumber(Student.getPhoneNumber());
		student.setLastName(Student.getLastname());
		student.setJMBG(Student.getJMBG());
		student.setFirstName(Student.getFirstname());
		student.seteMail(Student.getEmail());
		student.setDateOfBirth(Student.getDateOfBirth());
		student.setCurrentAddress(Student.getCurrentAddress());
		studentService.save(student);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@RequestMapping( method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKurs(@RequestParam("id") Long id){
		Student Student = studentService.findOne(id);
		if (Student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = {"multipart/form-data"} ,value="/upload")
	@ResponseBody
	public  void  saveEBook(@RequestPart("student") Student student,@RequestPart("file") MultipartFile file) throws IOException{
		String storagePath = ResourceBundle.getBundle("app").getString("storage");
		 try {

	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(storagePath + file.getOriginalFilename());
	            Files.write(path, bytes);
	            Dokument dokument = new Dokument();
	            dokument.setNaziv(file.getOriginalFilename());
	            dokument.setStudent(student);
	            dokumentService.save(dokument);
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
		
			
	}
	
	@RequestMapping(path = "/download", method = RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<Resource> download(@RequestParam("filename") String filename) throws IOException {
		String storagePath = ResourceBundle.getBundle("app").getString("storage");
        File file = new File(storagePath+filename);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }
	
	@RequestMapping(path = "/getDokumentsByStudent", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<ArrayList<DokumentDTO>> getDokumentsForStudent(@RequestParam("username") String userName) {
		Student student=studentService.findByUserName(userName);
		List<Dokument> dokumentiStudenta=dokumentService.getByStudent(student);
		ArrayList<DokumentDTO> dokumentDTOs = new ArrayList<>();
		for (Dokument dokument : dokumentiStudenta) {
			dokumentDTOs.add(new DokumentDTO(dokument));
		}
		
		return new ResponseEntity<>(dokumentDTOs,HttpStatus.OK);
	}
		
	
}