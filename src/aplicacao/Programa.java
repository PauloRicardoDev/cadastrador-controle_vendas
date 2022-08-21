package aplicacao;

import model.entidades.Cliente;
import model.entidades.Endereco;
import model.entidades.Pedido;
import model.entidades.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Cadastra venda? [(s) - sim] ou [(n) - não]: ");
            var op1 = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            while (op1 == 'S') {
                System.out.println("Informe dados do cliente! ABAIXO");
                System.out.print("Nome: ");
                var nome = sc.nextLine();
                System.out.print("Cpf: ");
                var cpf = sc.nextLine();
                System.out.print("E-mail: ");
                var email = sc.nextLine();
                System.out.print("Telefone: ");
                var telefone = sc.nextLine();

                System.out.println();
                System.out.print("Qual a modaliade de da retirado do(s) produto(s) - [(1)loja] ou [(2)Em Casa]: ");
                var op2 = sc.nextInt();
                sc.nextLine();

                Cliente cliente = null;

                switch (op2) {
                    case 1:
                        cliente = new Cliente(nome, cpf, email, telefone,
                                new Endereco("66822-550", "1500b", "Loja-Tst"));
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("Endereço para entrega!");
                        System.out.print("Cep: ");
                        var cep = sc.nextLine();
                        System.out.print("Número do local da entrega: ");
                        var nLocal = sc.nextLine();
                        System.out.print("Ponto de referência: ");
                        var pdr = sc.nextLine();

                        cliente = new Cliente(nome, cpf, email, telefone,
                                new Endereco(cep, nLocal, pdr));

                        break;
                    default:
                        System.out.println("Erro");
                        System.exit(0);
                        break;
                }
                
                Pedido pedido = new Pedido(cliente);
                var quantidadeProduto = 0;

                try {
                    System.out.println();
                    System.out.print("Qual a quantidade de produtos nesse pedido?: ");
                    quantidadeProduto = sc.nextInt();
                    sc.nextLine();

                    int[] vect2 = new int[quantidadeProduto];

                    if (quantidadeProduto >= 1){
                        for (int i = 0; i < vect2.length; i++) {
                            System.out.println();
                            System.out.println("Produto " + (i + 1));
                            System.out.print("Nome: ");
                            var nomeP = sc.nextLine();
                            System.out.print("Quantidade comprada: ");
                            var quantidadeCP = sc.nextInt();
                            System.out.print("Preço: ");
                            var preco = sc.nextDouble();
                            sc.nextLine();

                            Produto produto = new Produto(nomeP, quantidadeCP, preco);
                            pedido.addListaPedido(produto);
                        }
                    }
                    else {
                        System.out.println("Erro: Reinicio o cadstro da venda!");
                        System.exit(0);
                    }


                } catch (InputMismatchException e) {
                    System.out.println("Errro não é permitido o uso de letras, leia com atenção o comando!");
                    System.out.println("Faça novamente o cadstro!");
                    System.exit(0);
                }
                System.out.println("Venda Cadastrada com sucesso!");

                String[] linhasIniciais = new String[]{pedido.toString()};

                var path = "/home/meu_computador"; //caaminho do meu usuário, você pode definir o seu, estou usando linux - distro ubuntu

                boolean sucesso =  new File(path + "/Vendas").mkdir();
                //Criando uma pasta pra armazenar a nota.
                System.out.println("Deu certo? " + sucesso);

                path = ("/home/meu_computador/Vendas/arquivosVendas.txt");//declarando o caminho da nota.

                //leitura e gravação do cliente em nota/ArquivoVendas.txt
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

                    for (String linhas : linhasIniciais) {
                        bw.write(linhas);
                        bw.newLine();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }

                var soma = 0.00;

                //leitura e e gravação dos produtos na lista de produtos em nota/ArquivoVendas.txt
                for (int i = 0; i < quantidadeProduto; i++){

                    String[] linhasMed = new String[]{pedido.getProdutos().get(i).toString()};

                    path = ("/home/meu_computador/Vendas/arquivosVendas.txt");

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

                        for (String linhas : linhasMed) {
                            bw.write(linhas);
                            bw.newLine();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                    soma += pedido.getProdutos().get(i).valorAPagar();
                }

                //leitura e e gravação da soma dos valores de cada produto em pedido, na nota/ArquivoVendas.txt
                String[] linhafinal = new String[]{"Valor total da venda: R$" + String.format("%.2f", soma)};

                path = ("/home/meu_computador/Vendas/arquivosVendas.txt");

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

                    for (String linha : linhafinal) {
                        bw.write(linha);
                        bw.newLine();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }

                System.out.println();
                System.out.print("Cadastra venda? [(s) - sim] ou [(n) - não]: ");
                op1 = sc.next().toUpperCase().charAt(0);
                sc.nextLine();

            }
            if (op1 == 'N') {
                System.out.println("Fim !!!");
            } else {
                System.out.println("ERRO: Fique atento ao que se pede, faça o cadstro novamente!");
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
