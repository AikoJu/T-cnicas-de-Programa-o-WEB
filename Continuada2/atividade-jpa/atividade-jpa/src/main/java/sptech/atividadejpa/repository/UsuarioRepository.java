package sptech.atividadejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.atividadejpa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
