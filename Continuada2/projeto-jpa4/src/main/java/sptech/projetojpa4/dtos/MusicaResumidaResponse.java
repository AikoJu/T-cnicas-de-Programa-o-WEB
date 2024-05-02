package sptech.projetojpa4.dtos;

import sptech.projetojpa4.dominio.Musica;

/*
Esta classe implementa 2 padrões de projeto:
DTO - Data Transfer Object. Serve para transportar dados apenas
Adapter - Ela "transforma", "adapta" um objeto em outro
 */
public class MusicaResumidaResponse {

    private Integer codigo;
    private String nome;
    private String compositor;

    /*
    O padrão Adapter foi implementado aqui no construtor
     */
    public MusicaResumidaResponse(Musica musica) {
        this.codigo = musica.getCodigo();
        this.nome = musica.getNome();
        this.compositor = musica.getCompositor().getNome();
    }
    // criar só os GETTERS dos atributos


    public String getCompositor() {
        return compositor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
