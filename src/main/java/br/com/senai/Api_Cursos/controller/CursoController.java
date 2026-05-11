
package br.com.senai.Api_Cursos.controller;

import br.com.senai.Api_Cursos.cursos.Curso;
import br.com.senai.Api_Cursos.cursos.CursoRepository;
import br.com.senai.Api_Cursos.cursos.DadosCadastroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired //indica para o Springboot que ele vai instanciar(criar) esse objeto
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastroCurso dados){
        repository.save(new Curso(dados));
    }
}