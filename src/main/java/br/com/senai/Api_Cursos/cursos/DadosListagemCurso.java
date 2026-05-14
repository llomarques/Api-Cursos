package br.com.senai.Api_Cursos.cursos;

import br.com.senai.Api_Cursos.periodo.Periodo;

public record DadosListagemCurso(
        String nome,
        Periodo periodo
) {
    public DadosListagemCurso(Curso curso){
        this(
                curso.getNome(),
                curso.getPeriodo()
        );
    }
}
