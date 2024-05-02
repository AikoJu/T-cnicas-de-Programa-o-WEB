package sptech.projetojpa2.dominio;

import jakarta.persistence.*;

@Entity
public class Compositor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nome;

    private String apelido;
    @Lob
    @Column(length = 3 * 1024 * 1024)
    private byte[] documento;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public byte[] getDocumento() {return documento;}

    public void setDocumento(byte[] documento) {this.documento = documento;}
}
