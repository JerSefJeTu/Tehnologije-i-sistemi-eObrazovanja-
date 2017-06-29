package com.ap.model.dokument;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.model.users.student.Student;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {

	public List<Dokument> findByStudent(Student student);
}
