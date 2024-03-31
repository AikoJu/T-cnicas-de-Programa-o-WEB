package sptech.projeto04;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicamentos")
    public class MedicamentosController {

    public List<Medicamento> medicamentos = new ArrayList<>();

        @GetMapping
        public ResponseEntity<List<Medicamento>> buscarMedicamentos(){
            if (medicamentos.isEmpty()){
                return ResponseEntity.status(204).build();
            }
            return ResponseEntity.status(200).body(medicamentos);
        };

        @PostMapping
    public ResponseEntity<Medicamento> cadastrarMedicamento(@RequestBody @Valid Medicamento medicamento){
            medicamentos.add(medicamento);
            return ResponseEntity.status(201).body(medicamento);
        }

        @PatchMapping("/{indice}")
    public ResponseEntity<Medicamento> atualizarMedicamento(@PathVariable("indice") int indice, @RequestBody @Valid Medicamento atualizacaoMedicamento) {
        if (indice < 0 || indice >= medicamentos.size()) {
            return ResponseEntity.status(204).build();
        }

        Medicamento medicamento = medicamentos.get(indice);
        medicamento.setValorUnd(atualizacaoMedicamento.getValorUnd());
        medicamento.setQuantidade(medicamento.getQuantidade() + atualizacaoMedicamento.getQuantidade());
        return ResponseEntity.status(200).body(medicamento);
    }

        @DeleteMapping("/{indice}")
    public ResponseEntity<Medicamento> apagarMedicamento(@PathVariable("indice") int indice){
            if (indice < 0 || indice >= medicamentos.size()) {
                return ResponseEntity.status(404).build();
            }
            medicamentos.remove(indice);
            return ResponseEntity.status(200).build();
        }

        @GetMapping("/controlados")
    public ResponseEntity<List<Medicamento>> retornarControlados (){
            if (medicamentos.isEmpty()){
                return ResponseEntity.status(204).build();
            }
            List<Medicamento> controlados =  medicamentos.stream().filter(medicamento -> medicamento.getPrecisaReceita()).toList();
            if (controlados.isEmpty()){
                return ResponseEntity.status(204).build();
            }
            return ResponseEntity.status(200).body(controlados);
        }
}
