package dsc.lab2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dsc.lab2.entidades.Comentario;

@Repository
public interface ComentarioDAO extends JpaRepository<Comentario, Long> {
	List<Comentario> findByDisciplinaId(Long id);
}
