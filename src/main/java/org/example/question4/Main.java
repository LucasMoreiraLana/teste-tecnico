package org.example.question4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("minha-unidade-de-persistencia");
        EntityManager em = emf.createEntityManager();

        UsuarioService usuarioService = new UsuarioService(em);
        boolean autenticado = usuarioService.autenticarUsuario("joao", "12345");
        System.out.println("Autenticado: " + autenticado);

        em.close();
        emf.close();
    }
}