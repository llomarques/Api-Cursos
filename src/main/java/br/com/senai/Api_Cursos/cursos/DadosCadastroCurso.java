package br.com.senai.Api_Cursos.cursos;

import br.com.senai.Api_Cursos.periodo.Periodo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCurso(
        @NotBlank
        @Column(unique = true)
        @Size(min=3, max=100)
        String nome,

        Periodo periodo

) {
}
