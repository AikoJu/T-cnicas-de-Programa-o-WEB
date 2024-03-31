package sptech.projeto04;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PatchMedicamentoQuantidadeValor {
    @NotNull
    @PositiveOrZero
    private Double novoValor;

}
