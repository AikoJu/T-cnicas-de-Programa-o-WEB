package sptech.projetojpa4.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.projetojpa4.repositorio.CompositorRepository;

@RestController
@RequestMapping("/compositores")
public class CompositorController {

    @Autowired
    private CompositorRepository repository;

    @GetMapping("/relatorio-completo")
    public ResponseEntity getRelatorio(){
        return ResponseEntity.status(200).body(repository.getRelatorio());
    }
}
