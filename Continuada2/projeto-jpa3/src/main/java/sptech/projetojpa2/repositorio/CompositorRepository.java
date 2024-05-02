package sptech.projetojpa2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpa2.dominio.Compositor;
import sptech.projetojpa2.dominio.Musica;

import java.util.List;

public interface CompositorRepository extends
        JpaRepository<Compositor, Integer> {



}



