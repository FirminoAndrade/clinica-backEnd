package br.com.clinicaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.clinicaapi.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query(nativeQuery = true, value = "Select * from aluno order by num desc;")
	List<Aluno> findAllDesc();

	@Query(nativeQuery = true, value = "select * from usuario where curso like (:curso)")
	List<Aluno> findByNomeAlunoPorCurso(@Param(value = "curso") String curso);
}
