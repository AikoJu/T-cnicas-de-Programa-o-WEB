package sptech.school.exerciciodynamicjpql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class FilmeConsultaDto {
    private Integer id;
    private String titulo;
    private String genero;
    private LocalDate dataLancamento;
    private Double custoProducao;
    private Integer nota;
    private String analise;
}