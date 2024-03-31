package sptech.projeto05;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/*
Esta classe implementa um padrão de projeto: DTO
Data Transfer Object
 */
public class MedicamentoPatchValorQuantidade {

    @NotNull
    @PositiveOrZero // @DecimalMin("0.0")
    private Double novoValorUnd;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeEntrada;

    public Double getNovoValorUnd() {
        return novoValorUnd;
    }

    public Integer getQuantidadeEntrada() {
        return quantidadeEntrada;
    }
}
