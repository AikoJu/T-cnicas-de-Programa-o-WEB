package school.sptech.treino.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class PersonagemConsultaDto {

    private Integer id;
    private LocalDate data;
    private String codinome;
    private String habilidade;
    private Double poder;
    private String classificacao;
    private Integer idadeAproximada;
}
