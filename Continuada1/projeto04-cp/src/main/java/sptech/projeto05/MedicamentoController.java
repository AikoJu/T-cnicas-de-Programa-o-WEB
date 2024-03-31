package sptech.projeto05;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

   private List<Medicamento> medicamentos = new ArrayList<>();

    @GetMapping("/simples")
    public ResponseEntity<List<MedicamentoSimples>> getSimples() {
        if (medicamentos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
  /*      List<MedicamentoSimples> lista = new ArrayList<>();
        for (Medicamento medicamento : medicamentos) {
            MedicamentoSimples medicamentoSimples = new MedicamentoSimples(medicamento);
            lista.add(medicamentoSimples);
        }*/
        /*List<MedicamentoSimples> lista = medicamentos.stream()
                .map(medicamento -> new MedicamentoSimples(medicamento))
                .toList();*/
//        return ResponseEntity.status(200).body(lista);
        return ResponseEntity.status(200).body(
                MedicamentoSimples.deLista(medicamentos));
    }

    @GetMapping("/relatorio-geral")
    public ResponseEntity<RelatorioGeral> getRelatorioGeral() {
        return ResponseEntity.status(200)
                .body(new RelatorioGeral(medicamentos));
    }

        @GetMapping
   public ResponseEntity<List<Medicamento>> get() {
       if (medicamentos.isEmpty()) {
           return ResponseEntity.status(204).build();
       }
       return ResponseEntity.status(200).body(medicamentos);
   }

   @PostMapping
   public ResponseEntity<Medicamento> criar(@RequestBody @Valid Medicamento novoMedicamento) {
       medicamentos.add(novoMedicamento);
       return ResponseEntity.status(201).body(novoMedicamento);
   }

   @PatchMapping("/{indice}")
   public ResponseEntity<Medicamento>
            atualizar(@PathVariable int indice,
                      @RequestBody @Valid
                      MedicamentoPatchValorQuantidade atualizacao) {

       if (indice < 0 || indice >= medicamentos.size()) {
           return ResponseEntity.status(404).build();
       }

       Medicamento medicamento = medicamentos.get(indice);
       medicamento.atualizarPrecoQuantidade(atualizacao);

       return ResponseEntity.status(200).body(medicamento);
   }

   void validarCodigo(Medicamento medicamento) {
       for (var atual : medicamentos) {
           if (atual.getCodigo().equals(medicamento.getCodigo())) {
               throw new ResponseStatusException(
                HttpStatusCode.valueOf(409), "Código já existe"
               );
           }
       }
   }

}



