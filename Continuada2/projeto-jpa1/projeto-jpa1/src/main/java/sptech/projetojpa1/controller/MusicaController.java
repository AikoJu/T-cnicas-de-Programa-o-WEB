package sptech.projetojpa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa1.model.Musica;
import sptech.projetojpa1.repository.MusicaRepository;
import java.util.List;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    @Autowired
private MusicaRepository repository;

@GetMapping
    public ResponseEntity<List<Musica>> get(){
    var lista = repository.findAll();
    return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
}


@PostMapping
    public  ResponseEntity<Musica> post(@RequestBody Musica novaMusica){
    repository.save(novaMusica);
    return ResponseEntity.status(201).body(novaMusica);
}

@GetMapping("/{codigo}")
    public ResponseEntity<Musica> get(@PathVariable int codigo) {
    return ResponseEntity.of(repository.findById(codigo));

//    if (repository.existsById(codigo)){
//        return ResponseEntity.status(200).body(repository.findById(codigo).get());
//    }
//    return ResponseEntity.status(404).build();
}


@DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable Integer codigo){
    if (repository.existsById(codigo)){
        repository.deleteById(codigo);
        return ResponseEntity.status(200).build();
    }
    return ResponseEntity.status(404).build();
}

@PutMapping("/{codigo}")
    public ResponseEntity<Musica> put(@PathVariable Integer codigo, @RequestBody Musica musica){
    if (repository.existsById(codigo)){
        musica.setCodigo(codigo);
        repository.save(musica);
        return ResponseEntity.status(200).body(musica);
    }
    return ResponseEntity.status(404).build();
}


}
