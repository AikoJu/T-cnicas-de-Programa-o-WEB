package school.sptech.avaliacaocontinuada1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    Integer idAtual = 0;
    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return ResponseEntity.status(409).build();
            }
        }
        if (usuario.getEmail().length() < 10) {
            return ResponseEntity.status(400).build();

        }
        if (!usuario.getEmail().contains("@")) {
            return ResponseEntity.status(400).build();

        } else {
            usuario.setId(idAtual += 1);
            usuarios.add(usuario);
            return ResponseEntity.status(201).body(usuario);
        }

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> exibirTodos() {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id){
        if (usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        for (Usuario u : usuarios){
            if (u.getId() == id){
                return ResponseEntity.status(200).body(u);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        if (usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return ResponseEntity.status(409).build();
            }
        }
        if (usuario.getEmail().length() < 10) {
            return ResponseEntity.status(400).build();

        }
        if (!usuario.getEmail().contains("@")) {
            return ResponseEntity.status(400).build();

        }
        if (usuario.getEmail() == null){
            return ResponseEntity.status(400).build();
        }else {
            Integer indice = null;
            for (int i = 0; i < usuarios.size() ; i++) {
                if (usuarios.get(i).getId() == id){
                    indice = i;

                usuarios.set(indice,usuario);
            }
            }
            return ResponseEntity.status(200).body(usuario);
    }}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable int id){
        if (usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        for (Usuario u : usuarios){
            if (u.getId() == id){
                usuarios.remove(u);
                return ResponseEntity.status(200).body("Usuário deletado.");
            }
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }



}

