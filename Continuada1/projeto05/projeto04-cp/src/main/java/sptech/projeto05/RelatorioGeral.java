package sptech.projeto05;

import java.util.List;

public class RelatorioGeral {
    private Integer totalMedicamentos;
    private Long totalControlados;
    private Long totalNacionais;
    private Double valorTotalEstoque;

    public RelatorioGeral(List<Medicamento> medicamentos) {
        totalMedicamentos = medicamentos.size();

        totalControlados = medicamentos.stream()
                            .filter(Medicamento::isPrecisaReceita)
                            .count();

        totalNacionais = medicamentos.stream()
                .filter(medicamento -> medicamento.getFabricante().isNacional())
                .count();

        valorTotalEstoque = medicamentos.stream()
                .mapToDouble(medicamento ->
                 medicamento.getQuantidade() * medicamento.getValorUnd())
                .sum();
    }

    public Integer getTotalMedicamentos() {
        return totalMedicamentos;
    }

    public Long getTotalControlados() {
        return totalControlados;
    }

    public Long getTotalNacionais() {
        return totalNacionais;
    }

    public Double getValorTotalEstoque() {
        return valorTotalEstoque;
    }
}
