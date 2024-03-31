package sptech.atividadejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.atividadejpa.model.Usuario;
import sptech.atividadejpa.repository.UsuarioRepository;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

@Autowired
private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        var lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        repository.save(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        if (repository.existsById(id)) {
            usuario.setId(id);
            repository.save(usuario);
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(404).build();
    }

}
