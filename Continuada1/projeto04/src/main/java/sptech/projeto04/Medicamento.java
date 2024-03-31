package sptech.projeto04;

import jakarta.validation.constraints.*;

public class Medicamento {
    @NotBlank
    @Size(min = 3, max = 5)
    private String codigo;
    @NotBlank
    @Size(min = 4, max = 30)
    private String nome;
    @NotNull
    @DecimalMin("0.0")
    private Double valorUnd;
    @NotNull
    @Min(0)
    private Integer quantidade;
    private Boolean precisaReceita;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorUnd() {
        return valorUnd;
    }

    public void setValorUnd(Double valorUnd) {
        this.valorUnd = valorUnd;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getPrecisaReceita() {
        return precisaReceita;
    }

    public void setPrecisaReceita(Boolean precisaReceita) {
        this.precisaReceita = precisaReceita;
    }


}