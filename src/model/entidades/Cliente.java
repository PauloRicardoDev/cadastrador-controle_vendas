package model.entidades;

import java.util.Random;

public final class Cliente {
    private String nome;
    private String cpf;
    static final Random id = new Random();
    private String email;
    private String telefone;
    private Endereco endereco;

    public Cliente() {}

    public Cliente(String nome, String cpf, String email, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return  "CLIENTE" + "\n" +
                "Nome: " + getNome() + "\n" +
                "Cpf: " + getCpf() + "\n" +
                "E-mail: " + getEmail() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Id Cliente: " + id.nextInt(100000);
    }

}
