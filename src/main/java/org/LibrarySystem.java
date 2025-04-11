package org.library;


import org.library.exceptions.LivroNaoEncontradoException;
import org.library.model.Livro;
import org.library.repository.Biblioteca;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();


        while (true) {
            System.out.println("1. Adicionar livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Remover livro");
            System.out.println("4. Exibir todos os livros");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção:");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite o título");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ano de publicação");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o ISBN");
                    String isbn = scanner.nextLine();

                    Livro livro = new Livro(titulo,isbn,ano,autor);

                    try {
                        biblioteca.adicionarLivro(livro);
                        System.out.println("Livro adicionado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    System.out.println("Digite o ISBN: ");
                    isbn = scanner.nextLine();

                    try {
                       Livro livroBuscado = biblioteca.buscarPorIsbn(isbn);
                        System.out.println("Livro encontrado: " + livroBuscado);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("Digite o ISBN: ");
                    isbn = scanner.nextLine();

                    try {
                        biblioteca.removerLivro(isbn);
                        System.out.println("Livro removido com sucesso!");
                    } catch (LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                        biblioteca.exibirLivros();

                        break;

                case 5:
                    System.out.println("Saindo");
                    return;

                default:
                    System.out.println("Opção inválida");



            }
        }








    }
}