package sptech.projeto03;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @RestController
// @RequestMapping("/pokemons")
public class PokemonController {

    private List<Pokemon> pokemons = new ArrayList<>();

    // URI: /pokemons
    @GetMapping // indica que método HTTP para chegar aqui é GET
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    // URI: /pokemons
    /*
@RequestBody -> Indica que o parâmetro será preenchido
                a partir de um JSON enviado pelo cliente
     */
    @PostMapping // indica que método HTTP para chegar aqui é POST
    public String criarPokemon(@RequestBody @Valid Pokemon novoPokemon) {
        pokemons.add(novoPokemon);
        return "Pokemon cadastrado com sucesso";
    }

    // URI: /pokemons"/{indice}
    @GetMapping("/{indice}")
    public Pokemon get(@PathVariable int indice) {
        return pokemons.get(indice);
    }

    // URI: /pokemons"/{indice}
    @DeleteMapping("/{indice}") // indica que método HTTP para chegar aqui é DELETE
    public Pokemon delete(@PathVariable int indice) {
        return pokemons.remove(indice);
    }

    // URI: /pokemons"/{indice}
    @PutMapping("/{indice}") // indica que método HTTP para chegar aqui é PUT
    public String atualizar(@PathVariable int indice,
                            @RequestBody Pokemon pokemon) {
        pokemons.set(indice, pokemon);
        return "Pokemon atualizado com sucesso";
    }


}



