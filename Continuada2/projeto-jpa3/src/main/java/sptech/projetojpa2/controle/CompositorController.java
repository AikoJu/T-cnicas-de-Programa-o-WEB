package sptech.projetojpa2.controle;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa2.repositorio.CompositorRepository;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/compositores")
public class CompositorController {
    @Autowired
    private CompositorRepository repository;

    @PatchMapping(value = "/documento/{codigo}", consumes = "text/csv")
    public ResponseEntity<Void> alterarDocumento(@PathVariable Integer codigo, @RequestBody byte[] documento) {
        var compositor = repository.findById(codigo).get();
        compositor.setDocumento(documento);
        repository.save(compositor);
        return status(204).build();
    }

    @GetMapping(value = "/documento/{codigo}", produces = "text/csv")
    public ResponseEntity<byte[]> getDocumento(@PathVariable Integer codigo) {
        byte[] documento = compositorService.getDocumento(codigo);

        if (documento == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).contentType(MediaType.parseMediaType("text/csv").body(documento));
    }
    @GetMapping(value = "/documento/{codigo}",produces = org.springframework.http.MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getDocumento(@PathVariable Integer codigo){
        return status(200).body(repository.findById(codigo));
    }
}
