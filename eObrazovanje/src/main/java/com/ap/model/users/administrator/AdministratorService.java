package com.ap.model.users.administrator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdministratorService {
	
	@Autowired
	AdministratorRepository administratorRepository;
	
	public Administrator findOne(Long id) {
		return administratorRepository.findOne(id);
	}

	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	public Administrator save(Administrator Administrator) {
		return administratorRepository.save(Administrator);
	}

	public void remove(Long id) {
		administratorRepository.delete(id);
	}

}
