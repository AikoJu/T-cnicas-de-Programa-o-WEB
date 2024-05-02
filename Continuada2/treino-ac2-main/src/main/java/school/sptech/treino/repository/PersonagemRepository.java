package school.sptech.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.treino.entity.Personagem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
    List<Personagem> findByCodinomeContainingIgnoreCase(String termo);

    List<Personagem> findByDataNascimentoAfter(LocalDate data);

    List<Personagem> findTop3ByOrderByPoderDesc();

    @Query("select p.poder from Personagem p order by p.poder LIMIT 1")
    Double menorPoder();
}

