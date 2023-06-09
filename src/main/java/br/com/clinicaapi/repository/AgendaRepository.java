package br.com.clinicaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.clinicaapi.entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	@Query("SELECT obj FROM Agenda obj WHERE obj.paciente.id = :id_agenda ORDER BY nome")
	List<Agenda> findByIdAgenda(@Param(value = "id_agenda") Long id_agenda);

	@Query(nativeQuery = true, value = "SELECT count(id) as soma FROM agenda WHERE id = id;")
	int findByQuantidadeAgendados();

	@Query(nativeQuery = true, value = "Select * from agenda order by id desc;")
	List<Agenda> findAllDesc();

}
