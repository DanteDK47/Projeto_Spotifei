package dao;
import java.sql.*;
import model.Usuario;
public class UsuarioDAO {
    public void cadastrar(Usuario u) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.execute();
        stmt.close();
        con.close();
    }
    public Usuario validarLogin(String email, String senha) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM usuario WHERE email=? AND senha=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        Usuario u = null;
        if (rs.next()) {
            u = new Usuario(rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
            u.setId(rs.getInt("id"));
        }
        rs.close();
        stmt.close();
        con.close();
        return u;
    }
}