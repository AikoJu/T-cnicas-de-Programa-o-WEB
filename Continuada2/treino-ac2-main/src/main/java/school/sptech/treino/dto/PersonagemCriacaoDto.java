package school.sptech.treino.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PersonagemCriacaoDto {
    private LocalDate data;
    private String nome;
    private String codinome;
    private String habilidade;
    private Double poder;
}
