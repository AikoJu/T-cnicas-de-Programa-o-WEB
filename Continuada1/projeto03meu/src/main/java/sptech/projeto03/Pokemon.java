package sptech.projeto03;

public class Pokemon {
    private  String nome;
    private String tipo;
    private Double forca;
    private boolean solto;

    public Pokemon(String nome, String tipo, Double forca, boolean solto) {
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.solto = solto;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getForca() {
        return forca;
    }

    public boolean isSolto() {
        return solto;
    }
}
