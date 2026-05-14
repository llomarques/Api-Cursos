package br.com.senai.Api_Cursos.cursos;

import br.com.senai.Api_Cursos.periodo.Periodo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findAllByAtivoTrue(Pageable paginacao);
    Optional<Curso> findByIdAndAtivoTrue(Long id);
    boolean existsByNomeAndPeriodoAndAtivoTrue(String nome, Periodo periodo);
}

