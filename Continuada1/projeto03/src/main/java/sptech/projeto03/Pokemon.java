package sptech.projeto03;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class Pokemon {

    @NotBlank
    @Size(min = 1,max = 15,message = "")
    private String nome;
    @NotNull
    private TipoPokemon tipo;
    @NotNull
    @DecimalMin("0.1")
    @DecimalMax(value = "100000.0")
    private Double forca;
    private boolean solto;

    private LocalDateTime criacao = LocalDateTime.now();

    public String getNome() {
        return nome;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public Double getForca() {
        return forca;
    }

    public boolean isSolto() {
        return solto;
    }

    public LocalDateTime getCriacao() {
        return criacao;
    }
}
