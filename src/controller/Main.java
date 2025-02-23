package src.controller;

import src.model.Produto;
import src.service.ProdutoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoService service = new ProdutoService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    service.adicionarProduto(new Produto(id, nome, preco));
                    System.out.println("Produto adicionado!");
                    break;
                case 2:
                    System.out.println("Lista de Produtos:");
                    service.listarProdutos().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("ID do produto a remover: ");
                    int idRemover = scanner.nextInt();
                    if (service.removerProduto(idRemover))
                        System.out.println("Produto removido!");
                    else
                        System.out.println("Produto não encontrado.");
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }
}
