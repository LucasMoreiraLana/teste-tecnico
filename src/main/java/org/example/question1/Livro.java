package org.example.question1;

import java.util.HashSet;

public class Livro {
    private String titulo;
    private int anoPublicacao;

    public Livro(String titulo, int anoPublicacao) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }
    //Aqui eu verifico se é o mesmo objeto na memória;
    //Depois verifico se é nulo ou de classe diferente;
    //Depois converto para o obj Livro;
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Mesmo objeto na memória
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica se é null ou de classe diferente
        Livro outroLivro = (Livro) obj; // Converte o objeto para Livro
        return anoPublicacao == outroLivro.anoPublicacao &&
                (titulo != null ? titulo.equals(outroLivro.titulo) : outroLivro.titulo == null);
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + anoPublicacao;
        return result;
    }

    public String getTitulo() { return titulo; }
    public int getAnoPublicacao() { return anoPublicacao; }

    //Abaixo está o teste do equals e Hashset
    public static void main(String[] args) {
        Livro livro1 = new Livro("Java para Iniciantes", 2020);
        Livro livro2 = new Livro("Java para Iniciantes", 2020);
        Livro livro3 = new Livro("Python Básico", 2021);

        System.out.println("livro1 equals livro2: " + livro1.equals(livro2));
        System.out.println("livro1 equals livro3: " + livro1.equals(livro3));

        HashSet<Livro> livros = new HashSet<>();
        livros.add(livro1);
        livros.add(livro2);
        System.out.println("Tamanho do HashSet: " + livros.size());
    }
    //Esperamos as saídas abaixo:

    //-livro1 equals livro2: true
    //-livro1 equals livro3: false
    //-Tamanho do HashSet: 1
}
