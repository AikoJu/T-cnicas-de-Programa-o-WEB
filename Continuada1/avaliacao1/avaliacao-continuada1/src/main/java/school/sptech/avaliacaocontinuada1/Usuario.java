package school.sptech.avaliacaocontinuada1;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String email;
    private String nome;
    private String senha;
    private LocalDate dataNascimento;

    public Usuario(String email, String nome, String senha, LocalDate dataNascimento) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
