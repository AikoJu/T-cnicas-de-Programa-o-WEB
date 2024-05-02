package school.sptech.treino.dto;


import org.springframework.stereotype.Component;
import school.sptech.treino.entity.Personagem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonagemMapper {
    public static String classificacao(Double poder){
        if (poder >= 0 && poder <=20 ){
            return "Muito fraco";
        }else if (poder > 20 && poder <=40 ){
            return "Fraco";
        }else if (poder > 40 && poder <=70){
            return "Mediano";
        }else if (poder > 70 && poder <= 80){
            return "Forte";
        }
        return "Super Poderoso";
    };
    public static Personagem toEntity(PersonagemCriacaoDto personagemCriacaoDto) {
        Personagem personagem = new Personagem();
        personagem.setDataNascimento(personagemCriacaoDto.getData());
        personagem.setNome(personagemCriacaoDto.getNome());
        personagem.setCodinome(personagemCriacaoDto.getCodinome());
        personagem.setHabilidade(personagemCriacaoDto.getHabilidade());
        personagem.setPoder(personagemCriacaoDto.getPoder());
        return personagem;
    }

    public static PersonagemConsultaDto toDto(Personagem personagem) {
        Double poder = personagem.getPoder();
        String classificacao = classificacao(poder);
        int idade = Period.between(personagem.getDataNascimento(), LocalDate.now()).getYears();

            PersonagemConsultaDto dto = new PersonagemConsultaDto(personagem.getId(),
                    personagem.getDataNascimento(),
                    personagem.getCodinome(),
                    personagem.getHabilidade(),
                    poder,
                    classificacao,
                    idade);
            return dto;
    }

    public static List<PersonagemConsultaDto> toDto(List<Personagem> personagens) {
        List<PersonagemConsultaDto> listaConsulta = new ArrayList<>();
        for (Personagem personagem : personagens){
            Double poder = personagem.getPoder();
            String classificacao = classificacao(poder);
            int idade = Period.between(personagem.getDataNascimento(), LocalDate.now()).getYears();

            PersonagemConsultaDto dto = new PersonagemConsultaDto(personagem.getId(),
                    personagem.getDataNascimento(),
                    personagem.getCodinome(),
                    personagem.getHabilidade(),
                    poder,
                    classificacao,
                    idade);

            listaConsulta.add(dto);
        }
        return listaConsulta;
    }
}
