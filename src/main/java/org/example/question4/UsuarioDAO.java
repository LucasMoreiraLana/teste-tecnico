package org.example.question4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public boolean autenticarUsuario(String usuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conn = obterConexao(); // Assume que obtém a conexão
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se encontrar o usuário
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Connection obterConexao() {
        return null;
    }


}