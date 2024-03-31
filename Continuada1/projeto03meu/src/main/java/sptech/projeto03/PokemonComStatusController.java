package sptech.projeto03;

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

    @GetMapping
    public ResponseEntity <List<Pokemon>> getPokemons() {
        if (pokemons.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pokemons);
    }

    @PostMapping
    public ResponseEntity <Pokemon> criarPokemon(@RequestBody Pokemon novoPokemon){
        pokemons.add(novoPokemon);
        return ResponseEntity.status(201).body(novoPokemon);
    }

    @GetMapping("/{indice}")
    public ResponseEntity <Pokemon> get(@PathVariable int indice){
        if (indice >= 0 && indice < pokemons.size()){
            return ResponseEntity.status(200).body(pokemons.get(indice));
        }
        return  ResponseEntity.status(404).build() ;
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Pokemon>  delete(@PathVariable int indice){
        if (indice >= 0 && indice < pokemons.size()) {
            pokemons.remove(indice);
            return ResponseEntity.status(204).build();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(404));
    }

    @PutMapping("/{indice}")
    public RequestMapping atualizar(@PathVariable int indice, @RequestBody Pokemon pokemonAtualizado){
        pokemons.set(indice,pokemonAtualizado);
        return "Pokemon atualizado";
    }

}
