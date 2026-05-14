package br.com.senai.Api_Cursos.cursos;


import br.com.senai.Api_Cursos.periodo.Periodo;

public record DadosDetalhamentoCurso(
        String nome,
        Periodo periodo
) {
    public DadosDetalhamentoCurso(Curso curso){
        this(
                curso.getNome(),
                curso.getPeriodo()
        );
    }
}

