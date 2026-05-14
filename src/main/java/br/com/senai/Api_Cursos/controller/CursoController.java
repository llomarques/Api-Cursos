
package br.com.senai.Api_Cursos.controller;

import br.com.senai.Api_Cursos.cursos.*;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired //indica para o Springboot que ele vai instanciar(criar) esse objeto
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCurso(@RequestBody @Valid DadosCadastroCurso dados){

        boolean existe = repository.existsByNomeAndPeriodoAndAtivoTrue(
                dados.nome(),
                dados.periodo()
        );

        if (existe) {
            return ResponseEntity.badRequest()
                    .body("Já existe um curso com esse nome e período");
        }

        repository.save(new Curso(dados));

        return ResponseEntity.ok("Curso cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCurso>> listarCursos(@PageableDefault(size = 10, sort = {"nome"}) @ParameterObject Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemCurso::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCurso> buscarCursoPorId(@PathVariable Long id){
        var curso = repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }


    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCurso(@PathVariable Long id){

        var curso = repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Curso não encontrado"
                ));

        curso.excluirCurso();
    }
}

