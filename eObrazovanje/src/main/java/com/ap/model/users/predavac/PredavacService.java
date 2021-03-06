package com.ap.model.users.predavac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.model.users.student.Student;

@Service
public class PredavacService {
		
		@Autowired
		PredavacRepository predavacRepository;
		
		public Predavac findOne(Long id) {
			return predavacRepository.findOne(id);
		}

		public List<Predavac> findAll() {
			return predavacRepository.findAll();
		}

		public Predavac save(Predavac Predavac) {
			return predavacRepository.save(Predavac);
		}

		public void remove(Long id) {
			predavacRepository.delete(id);
		}
		
		public Predavac findByUserName(String username) {
			return predavacRepository.findByUserName(username);
		}

}
