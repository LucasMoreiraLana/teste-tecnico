package org.example.question4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UsuarioService {
    private EntityManager em;

    public UsuarioService(EntityManager em) {
        this.em = em;
    }

    //removendo caracteres perigosos
    private String sanitizarEntrada(String input) {
        if (input == null) return "";
        return input.replaceAll("[;'\"\\-]", "");
    }

    public boolean autenticarUsuario(String usuario, String senha) {

        String usuarioSanitizado = sanitizarEntrada(usuario);
        String senhaSanitizada = sanitizarEntrada(senha);

        Query query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", usuarioSanitizado);
        query.setParameter("password", senhaSanitizada);
        return !query.getResultList().isEmpty();
    }
}

