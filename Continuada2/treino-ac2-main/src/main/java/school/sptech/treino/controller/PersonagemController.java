package school.sptech.treino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.treino.dto.PersonagemConsultaDto;
import school.sptech.treino.dto.PersonagemCriacaoDto;
import school.sptech.treino.dto.PersonagemMapper;
import school.sptech.treino.entity.Personagem;
import school.sptech.treino.repository.PersonagemRepository;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    @Autowired
    PersonagemRepository repository;

    @GetMapping
    public ResponseEntity<List<PersonagemConsultaDto>> listagem() {
        var lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(PersonagemMapper.toDto(lista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemConsultaDto> buscaPorId(@PathVariable Integer id) {
        Personagem personagem = repository.findById(id).orElse(null);
        PersonagemConsultaDto personagemDto = PersonagemMapper.toDto(personagem);
        return ResponseEntity.status(200).body(personagemDto) ;
    }

    @PostMapping
    public ResponseEntity<PersonagemConsultaDto> cria(PersonagemCriacaoDto personagemCriacaoDto) {
        var personagem = PersonagemMapper.toEntity(personagemCriacaoDto);
        repository.save(personagem);
        return ResponseEntity.status(201).body(PersonagemMapper.toDto(personagem));
    }

    @GetMapping("/codinome")
    public ResponseEntity<List<PersonagemConsultaDto>> buscarPorCodinomeAproximado(@RequestParam String termo){
        var lista = repository.findByCodinomeContainingIgnoreCase(termo);
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(PersonagemMapper.toDto(lista)) ;
    }

    @GetMapping("/nascidos-apos")
    public ResponseEntity<List<PersonagemConsultaDto>> buscarNascidosApos(@RequestParam String data) {
        var lista = repository.findByDataNascimentoAfter(LocalDate.parse(data));
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(PersonagemMapper.toDto(lista));
    }

    @GetMapping("/top-3")
    public ResponseEntity<List<PersonagemConsultaDto>> buscarTop3() {
        var lista = repository.findTop3ByOrderByPoderDesc();
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(PersonagemMapper.toDto(lista));
    }

    @GetMapping("/menor-poder")
    public ResponseEntity<Double> buscarMenorPoder() {
        Double menorPoder = repository.menorPoder();
        return menorPoder.isNaN() ? ResponseEntity.status(200).body(0.0) : ResponseEntity.status(200).body(menorPoder);
    }
}
