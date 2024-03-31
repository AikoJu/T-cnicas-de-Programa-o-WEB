package sptech.autolegal;

import jakarta.validation.constraints.*;

import java.util.UUID;

public class Carro {
     private UUID id = UUID.randomUUID();
    @NotBlank
    @Size(min = 7, max = 8)
    private String placaCarro;
    @Min(1960)
    @PastOrPresent
    private Integer ano;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;
    @NotNull
    @DecimalMin("0.01")
    private Double preco;

    @Null
    private String motivoMudancaPlaca;

    public Carro(String placaCarro, Integer ano, String marca, String modelo, Double preco) {
        this.placaCarro = placaCarro;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.motivoMudancaPlaca = motivoMudancaPlaca;
    }

    public UUID getId() {
        return id;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public String getMotivoMudancaPlaca() {
        return motivoMudancaPlaca;
    }
}
