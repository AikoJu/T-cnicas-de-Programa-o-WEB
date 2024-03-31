package sptech.projeto03;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/pokemons")
public class PokemonController {

    private List<Pokemon> pokemons = new ArrayList<>();

    @GetMapping
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @PostMapping
    public String criarPokemon(@RequestBody Pokemon novoPokemon){
        pokemons.add(novoPokemon);
        return "Pokemón cadastrado com sucesso!";
    }

    @GetMapping("/{indice}")
    public Pokemon get(@PathVariable int indice){
        return pokemons.get(indice);
    }


    @DeleteMapping("/{indice}")
    public Pokemon delete(@PathVariable int indice){
        return pokemons.remove(indice);
    }
    @PutMapping("/{indice}")
    public String atualizar(@PathVariable int indice, @RequestBody Pokemon pokemonAtualizado){
           pokemons.set(indice,pokemonAtualizado);
            return "Pokemon atualizado";
    }


}
