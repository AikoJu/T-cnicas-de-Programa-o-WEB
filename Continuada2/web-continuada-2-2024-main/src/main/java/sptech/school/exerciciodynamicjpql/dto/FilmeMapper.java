package sptech.school.exerciciodynamicjpql.dto;

import org.springframework.stereotype.Component;
import sptech.school.exerciciodynamicjpql.entity.Filme;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmeMapper {
    public static String analise(Integer nota){
        if(nota < 5 ){
            return "Flopou!";
        } else if (nota >= 5 && nota < 8) {
            return "Sessão da tarde";
        }
        return "Absolute cinema!";
    }
    public static FilmeConsultaDto toDto(Filme filme) {
        String analise = analise(filme.getNota());
        FilmeConsultaDto dto = new FilmeConsultaDto(
                filme.getId(),
                filme.getTitulo(),
                filme.getGenero(),
                filme.getDataLancamento(),
                filme.getCustoProducao(),
                filme.getNota(),
                analise);
        return dto;
    }

    public static List<FilmeConsultaDto> toDto(List<Filme> entities) {
        List<FilmeConsultaDto> lista = new ArrayList<>();

        for (Filme filme : entities ){
            String analise = analise(filme.getNota());
            FilmeConsultaDto dto = new FilmeConsultaDto(
                    filme.getId(),
                    filme.getTitulo(),
                    filme.getGenero(),
                    filme.getDataLancamento(),
                    filme.getCustoProducao(),
                    filme.getNota(),
                    analise);
            lista.add(dto);
        }
        return lista;
    }

    public static Filme toEntity(FilmeCriacaoDto dto) {
        Filme filme = new Filme();
        filme.setTitulo(dto.getTitulo());
        filme.setGenero(dto.getGenero());
        filme.setDataLancamento(dto.getDataLancamento());
        filme.setCustoProducao(dto.getCustoProducao());
        filme.setNota(dto.getNota());
        return filme;
    }
}
