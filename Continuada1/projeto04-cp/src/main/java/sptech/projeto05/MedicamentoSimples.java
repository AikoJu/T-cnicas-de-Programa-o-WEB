package sptech.projeto05;

import java.util.List;

/*
Esta classe implementa o padrão de projeto: DTO
Data Transfer Object

Ela também implementa o APADTER (vide construtor e método estático)
 */
public class MedicamentoSimples {

    private String codigo;
    private String nome;
    private String fabricante;
    private Double preco;
    private Double totalEmEstoque;

    // Com este construtor nós implementamos o padrão ADAPTER
    public MedicamentoSimples(Medicamento medicamento) {
        this.codigo = medicamento.getCodigo();
        this.nome = medicamento.getNome();
        this.fabricante = medicamento.getFabricante().getNome();
        this.preco = medicamento.isPrecisaReceita()
                    ? null
                    : medicamento.getValorUnd();

        if (this.preco != null) {
            this.totalEmEstoque = preco * medicamento.getQuantidade();
        }
    }

    // Com este método nós implementamos o padrão ADAPTER
    public static List<MedicamentoSimples>
                    deLista(List<Medicamento> listaOriginal) {
        return
        listaOriginal.stream().map(MedicamentoSimples::new).toList();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getTotalEmEstoque() {
        return totalEmEstoque;
    }
}
