package com.ap.model.predispitnaObaveza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.model.kurs.Kurs;

public interface PredispitnaObavezaRepository extends JpaRepository<PredispitnaObaveza, Long> {

	public List<PredispitnaObaveza> findByKurs(Kurs kurs);
}
