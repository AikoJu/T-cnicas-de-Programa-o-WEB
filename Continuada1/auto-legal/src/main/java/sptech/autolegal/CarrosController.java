package sptech.autolegal;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    private List<Carro> carros = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Carro>> exibirCarros(){
        if (carros.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(carros);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody @Valid Carro carro){
        for (Carro c: carros){
            if (c.getPlacaCarro().equals(carro.getPlacaCarro())) {
                return ResponseEntity.status(409).build();
            }
        }
        carros.add(carro);
        return ResponseEntity.status(200).body(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> pesquisarPorId(@PathVariable  UUID id){
        if (carros.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        Carro
        for (Carro c: carros){
            if (c.getId().equals(id)){

            }
        }
    }


}
