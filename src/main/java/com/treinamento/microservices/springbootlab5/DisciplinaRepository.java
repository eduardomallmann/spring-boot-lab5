package com.treinamento.microservices.springbootlab5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "/disciplina")
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	@RestResource(path = "next", rel = "next")
	@Query("select d from Disciplina d where d.dataInicio > current_date")
	List<Disciplina> listNextCourses();

}
