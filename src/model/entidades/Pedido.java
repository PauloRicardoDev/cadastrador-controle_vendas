package model.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
public final class Pedido {
    private Cliente cliente;
    static final Random id = new Random();
    private final List<Produto> produtos = new ArrayList<>();
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Pedido() {}
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void addListaPedido(Produto produto){
        produtos.add(produto);
    }
    @Override
    public String toString() {
        return  "--------------------------------------------------------------------------------------------" + "\n" +
                "Id Pedido: " + id.nextInt(100000) + "\n" +
                "Data e Hora: " + sdf.format(new Date()) + "\n" +
                "" + "\n" +
                cliente.toString() + "\n" +
                cliente.getEndereco().toString();
    }

}
