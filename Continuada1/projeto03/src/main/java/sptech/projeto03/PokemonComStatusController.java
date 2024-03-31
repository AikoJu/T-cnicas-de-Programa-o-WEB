package sptech.projeto03;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

 @RestController
 @RequestMapping("/pokemons")
public class PokemonComStatusController {

    private List<Pokemon> pokemons = new ArrayList<>();

    // URI: /pokemons
    @GetMapping // indica que método HTTP para chegar aqui é GET
    public ResponseEntity<List<Pokemon>> getPokemons() {
        if (pokemons.isEmpty()) {
            // criada uma resposta HTTP com status 204 e SEM corpo (build)
            return ResponseEntity.status(204).build();
        }
        // criada uma resposta HTTP com status 200
        // e a lista "pokemons" no corpo
        return ResponseEntity.status(200).body(pokemons);
    }

    // URI: /pokemons
    /*
@RequestBody -> Indica que o parâmetro será preenchido
                a partir de um JSON enviado pelo cliente
     */
    @PostMapping // indica que método HTTP para chegar aqui é POST
    public ResponseEntity<Pokemon> criarPokemon(@RequestBody @Valid Pokemon novoPokemon) {
        pokemons.add(novoPokemon);
        // criada uma resposta HTTP com status 201
        // o "novoPokemon" no corpo
        return ResponseEntity.status(201).body(novoPokemon);
    }

    // URI: /pokemons"/{indice}
    @GetMapping("/{indice}")
    public ResponseEntity<Pokemon> get(@PathVariable int indice) {
        if (indice >=0 && indice < pokemons.size()) {
            return ResponseEntity.status(200)
                                 .body(pokemons.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    // URI: /pokemons"/{indice}
    @DeleteMapping("/{indice}") // indica que método HTTP para chegar aqui é DELETE
    public ResponseEntity<Pokemon> delete(@PathVariable int indice) {
        if (indice >=0 && indice < pokemons.size()) {
            pokemons.remove(indice);
            // é comum retornar 204 sem corpo em exclusões
            return ResponseEntity.status(204).build();
        }
        // é possível retornar um status de erro
        // LANÇANDO uma ResponseStatusException
//        throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        throw new ResponseStatusException(
                HttpStatusCode.valueOf(404), "Pokemon não encontrado");
    }

    // URI: /pokemons"/{indice}
    @PutMapping("/{indice}") // indica que método HTTP para chegar aqui é PUT
    public String atualizar(@PathVariable int indice,
                            @RequestBody Pokemon pokemon) {
        pokemons.set(indice, pokemon);
        return "Pokemon atualizado com sucesso";
    }

    
}



