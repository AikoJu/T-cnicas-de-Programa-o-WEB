package sptech.projetojpa2.repositorio;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import sptech.projetojpa2.dominio.Musica;

import java.time.LocalDate;
import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    List<Musica> findByNome(String nome);
    List<Musica> findByNomeContains(String nome);
    List<Musica> findByLancamentoAfter(LocalDate data);
    List<Musica> findTop3ByOrderByLancamento();
    List<Musica> findByClassicoTrue();
    List<Musica> findByEstiloAndClassico(String estilo, Boolean classico);
    List<Musica> findTop3ByOrderByOuvintesTotalDesc();
    Integer countMusicaByEstilo(String estilo);
    Integer countMusicaByOuvintesTotalLessThan(Integer minimo);

    @Transactional
    @Modifying
    void deleteByOuvintesTotalLessThan(Integer minimo);
}
