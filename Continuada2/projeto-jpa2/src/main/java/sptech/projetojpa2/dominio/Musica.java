package sptech.projetojpa2.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/*
@Entity -> Indica que a classe é uma Entidade
            Ou seja, ela mapeia, "espelha" uma tabela
 */
@Entity
public class Musica {

    @Id // do pacote jakarta.persistence -> indica que este atributo é o "id", ou seja, a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que a chave primária é auto-incremento
    private Integer codigo;
    @NotBlank
    @Size(min = 2, max = 30)
    private String nome;
    private Integer ouvintesTotal;
    @NotNull
    private LocalDate lancamento;
    @NotBlank
    private String estilo;
    private Boolean classico;

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Boolean getClassico() {
        return classico;
    }

    public void setClassico(Boolean classico) {
        this.classico = classico;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    // todos os campos precisam ter get e set para que funcionem corretamente
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getOuvintesTotal() {
        return ouvintesTotal;
    }

    public void setOuvintesTotal(Integer ouvintesTotal) {
        this.ouvintesTotal = ouvintesTotal;
    }

}
