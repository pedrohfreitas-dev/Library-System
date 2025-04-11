package dev.pedrohfreitas.repository;

import dev.pedrohfreitas.exceptions.BibliotecaCheiaException;
import dev.pedrohfreitas.exceptions.LivroNaoEncontradoException;
import dev.pedrohfreitas.model.Livro;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca  {
    private ArrayList<Livro> livros;
    private HashMap<String, Livro> livrosPorIsbn;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.livrosPorIsbn = new HashMap<>();
    }

  public void adicionarLivro(Livro livro)  {
      if (livros.size() >= 100) {
          throw new BibliotecaCheiaException("Biblioteca cheia");
      }
      livros.add(livro);
      livrosPorIsbn.put(livro.getIsbn(), livro);
  }

  public Livro buscarPorIsbn(String isbn)  {
      if (!livrosPorIsbn.containsKey(isbn)) {
          throw new LivroNaoEncontradoException(("Livro com ISBN " + isbn + " não encontrado"));
      } return livrosPorIsbn.get(isbn);
  }

  public void removerLivro(String isbn){
      if (livrosPorIsbn.containsKey(isbn)) {
          livrosPorIsbn.remove(isbn);
          return;
      }
      throw new LivroNaoEncontradoException("ISBN inexistente");
  }

  public void exibirLivros() {
      for (Livro livro : livros) {
          System.out.println(livro);
      }
  }



}
