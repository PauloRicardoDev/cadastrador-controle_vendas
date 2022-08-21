package model.entidades;

import java.util.Random;
public final class Produto {

    static final Random id = new Random();
    private String nome;
    private Integer quantidadeCompra;
    private Double preco;

    public Produto() {}

    public Produto(String nome, Integer quantidade, Double preco) {
        this.nome = nome;
        this.quantidadeCompra = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public Double getPreco() {
        return preco;
    }

    public void setQuantidadeCompra(Integer quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double valorAPagar(){
        return preco * quantidadeCompra;
    }


    @Override
    public String toString() {
        return  "PRODUTO" + "\n" +
                "Nome: " + getNome() + "\n" +
                "Id: " + id.nextInt(100000) + "\n" +
                "Preço: R$" + String.format("%.2f", getPreco()) + "\n" +
                "Quantidade sendo comprada: " + getQuantidadeCompra() + "\n" +
                "Valor a pagar: R$" + String.format("%.2f", valorAPagar()) + "\n" +
                "";
    }
}
