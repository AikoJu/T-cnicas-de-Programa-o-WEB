package sptech.projetojpa4.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpa4.dominio.Compositor;
import sptech.projetojpa4.dominio.CompositorRelatorioCompletoResponse;

import java.util.List;
import java.util.Map;

public interface CompositorRepository extends
        JpaRepository<Compositor, Integer> {

    @Query("select new sptech.projetojpa4.dominio.CompositorRelatorioCompletoResponse(c.codigo, c.apelido, "+
            "(select count (m) from Musica m where m.compositor = c))" +
            " from Compositor c group by c.codigo, c.apelido")
    List<CompositorRelatorioCompletoResponse> getRelatorio();

}
