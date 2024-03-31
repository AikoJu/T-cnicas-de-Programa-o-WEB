package sptech.projetojpa2.controle;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa2.dominio.Musica;
import sptech.projetojpa2.repositorio.MusicaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    /*
    @Autowired -> Indica que é de responsabilidade do Spring em instanciar o objeto,
    no caso, o 'repository'.
    Assim, quando qualquer dos método da classe precisar do 'repository', ele já terá um valor válido
     */
    @Autowired
    private MusicaRepository repository;

    @GetMapping
    public ResponseEntity<List<Musica>> get() {
        // findAll() -> equivale a um "select * from tabela"
        var lista = repository.findAll();
//        List<Musica> lista = repository.findAll();
        return lista.isEmpty()
                ? status(204).build()
                : status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Musica> post(@RequestBody @Valid Musica novaMusica) {
        // save() -> equivale a um "insert into tabela" ou a um "update tabela". Se o campo que for a Id será um insert, caso contrário, um update
        repository.save(novaMusica);
        return status(201).body(novaMusica);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Musica> get(@PathVariable Integer codigo) {
        /*
ResponseEntity.of() -> retorna, automaticamente:
404 e sem corpo, se seu argumento não tiver valor
200 e com corpo, se seu argumento tiver valor, que será o corpo da resposta
         */
        return ResponseEntity.of(repository.findById(codigo));
        // return of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable Integer codigo) {
        // existsById() -> retorna true se o valor é uma PK que existe para a entidade
        if (repository.existsById(codigo)) {
            // deleteById() -> equivale a um "delete from tabela where id = ?"
            repository.deleteById(codigo);
            return status(204).build();
        }
        return status(404).build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Musica> put(@PathVariable Integer codigo,
                                      @RequestBody @Valid Musica musica) {
        if (repository.existsById(codigo)) {
            musica.setCodigo(codigo);
            repository.save(musica);
            return status(200).body(musica);
        }

        return status(404).build();
    }

    @GetMapping("/filtro-nome/{nome}")
    public ResponseEntity<List<Musica>> getNome(@PathVariable String nome) {
        var lista = repository.findByNome(nome);
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);

    }

    @GetMapping("/filtro-nome2/{nome}")
    public ResponseEntity<List<Musica>> getNomeContains(@PathVariable String nome) {
        var lista = repository.findByNomeContains(nome);
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);

    }

    @GetMapping("/lancamento-after/{data}")
    public ResponseEntity<List<Musica>> getMusicaLancamento(@PathVariable LocalDate data) {
        var lista = repository.findByLancamentoAfter(data);

        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/lancamento-top")
    public ResponseEntity<List<Musica>> getMusicaLancamentoTop() {
        var lista = repository.findTop3ByOrderByLancamento();

        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/classicos")
    public ResponseEntity<List<Musica>> getClassicos() {
        var lista = repository.findByClassicoTrue();

        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/filtro-estilo/{estilo}/{classico}")
    public ResponseEntity<List<Musica>> getFiltroEstilo(@PathVariable String estilo, @PathVariable Boolean classico) {
        var lista = repository.findByEstiloAndClassico(estilo, classico);

        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/top3-tocadas")
    public ResponseEntity<List<Musica>> getMusicaTocadasTop() {
        var lista = repository.findTop3ByOrderByOuvintesTotalDesc();

        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/contagem-estilo/{estilo}")
    public ResponseEntity<Integer> getContagemEstilo(@PathVariable String estilo) {
        var valor = repository.countMusicaByEstilo(estilo);

        return ResponseEntity.status(200).body(valor);
    }

    @DeleteMapping("/ouvintes/{minimo}")
    public ResponseEntity<Integer> deleteOuvintes(@PathVariable Integer minimo){
        var valor = repository.countMusicaByOuvintesTotalLessThan(minimo);
        repository.deleteByOuvintesTotalLessThan(minimo);
        return ResponseEntity.status(200).body(valor);
    }

}


