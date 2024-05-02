package sptech.projetojpa4.dtos;

import sptech.projetojpa4.dominio.Musica;

/*
Esta classe implementa 2 padrões de projeto:
DTO - Data Transfer Object. Serve para transportar dados apenas
Adapter - Ela "transforma", "adapta" um objeto em outro
 */
public class MusicaSimplesResponse {

    private Integer codigo;
    private String nome;

    /*
    O padrão Adapter foi implementado aqui no construtor
     */
    public MusicaSimplesResponse(Musica musica) {
        this.codigo = musica.getCodigo();
        this.nome = musica.getNome();
    }
    // criar só os GETTERS dos atributos
    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
