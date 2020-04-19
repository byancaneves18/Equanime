package com.equanime.equanime.repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.equanime.equanime.models.Disciplina;
import com.equanime.equanime.models.Usuario;;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="INSERT INTO disciplina_professor (id_usuariofk, id_disciplinafk, periodo) values (:id_usuariofk, :id_disciplinafk, :periodo)", nativeQuery = true)
	public void criarProfessorDisciplina(@Param("id_disciplinafk") int disciplinaID, @Param("id_usuariofk") int professorID, @Param("periodo") int periodo);
	 
	 

}
