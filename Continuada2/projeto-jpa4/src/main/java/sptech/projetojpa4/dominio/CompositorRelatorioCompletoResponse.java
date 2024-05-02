package sptech.projetojpa4.dominio;

public class CompositorRelatorioCompletoResponse {

    private Integer codigo;
    private String apelido;
    private Long musicas;

    public CompositorRelatorioCompletoResponse(Integer codigo, String apelido, Long musicas) {
        this.codigo = codigo;
        this.apelido = apelido;
        this.musicas = musicas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getApelido() {
        return apelido;
    }

    public Long getMusicas() {
        return musicas;
    }
}
