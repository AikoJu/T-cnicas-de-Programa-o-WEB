package sptech.school.exerciciodynamicjpql.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.exerciciodynamicjpql.dto.FilmeConsultaDto;
import sptech.school.exerciciodynamicjpql.dto.FilmeCriacaoDto;
import sptech.school.exerciciodynamicjpql.dto.FilmeMapper;
import sptech.school.exerciciodynamicjpql.repository.FilmeRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    FilmeRepository repository;
//1.
    @GetMapping("/titulo")
    public ResponseEntity<List<FilmeConsultaDto>> buscarFilmePorTitulo(@RequestParam String nome) {
        var lista = repository.findByTituloContainingIgnoreCase(nome);
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(FilmeMapper.toDto(lista));
    }


    //2.
    @PostMapping
    public ResponseEntity<FilmeConsultaDto> criarFilme(@RequestBody @Valid FilmeCriacaoDto filme) {

        var filmeSalvo = FilmeMapper.toEntity(filme);
        repository.save(filmeSalvo);
        return ResponseEntity.status(201).body(FilmeMapper.toDto(filmeSalvo));
    }

    //3.
    @GetMapping("/data")
    public ResponseEntity<List<FilmeConsultaDto>> buscarFilmeEntreDatas(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        var lista = repository.findByDataLancamentoBetween(dataInicio,dataFim);
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(FilmeMapper.toDto(lista));
    }

    //4.
    @GetMapping("/menor-custo")
    public ResponseEntity<FilmeConsultaDto> buscarFilmeMaisBarato() {
        var filme = repository.findTop1ByOrderByCustoProducao();
        if (filme == null){
            return ResponseEntity.status(404).build();
        }
        return  ResponseEntity.status(200).body(FilmeMapper.toDto(filme));
    }
}

