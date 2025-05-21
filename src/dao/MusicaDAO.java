package dao;

import java.sql.*;
import model.Musica;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    public void cadastrar(Musica musica) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO musica (nome, artista, genero) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, musica.getNome());
        stmt.setString(2, musica.getArtista());
        stmt.setString(3, musica.getGenero());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public List<Musica> buscar(String termo, String campo) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM musica WHERE " + campo + " ILIKE ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + termo + "%");
        ResultSet rs = stmt.executeQuery();

        List<Musica> lista = new ArrayList<>();
        while (rs.next()) {
            Musica m = new Musica(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("artista"),
                rs.getString("genero")
            );
            lista.add(m);
        }

        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    public void curtir(int idUsuario, int idMusica) throws Exception {
        Connection con = Conexao.conectar();

        String checkSql = "SELECT status FROM musica_curtida WHERE id_usuario = ? AND id_musica = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setInt(1, idUsuario);
        checkStmt.setInt(2, idMusica);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String updateSql = "UPDATE musica_curtida SET status = 'curtiu' WHERE id_usuario = ? AND id_musica = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateSql);
            updateStmt.setInt(1, idUsuario);
            updateStmt.setInt(2, idMusica);
            updateStmt.executeUpdate();
            updateStmt.close();
        } else {
            String insertSql = "INSERT INTO musica_curtida (id_usuario, id_musica, status) VALUES (?, ?, 'curtiu')";
            PreparedStatement insertStmt = con.prepareStatement(insertSql);
            insertStmt.setInt(1, idUsuario);
            insertStmt.setInt(2, idMusica);
            insertStmt.executeUpdate();
            insertStmt.close();
        }

        rs.close();
        checkStmt.close();
        con.close();
    }

    public void descurtir(int idUsuario, int idMusica) throws Exception {
        Connection con = Conexao.conectar();

        String checkSql = "SELECT status FROM musica_curtida WHERE id_usuario = ? AND id_musica = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setInt(1, idUsuario);
        checkStmt.setInt(2, idMusica);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String updateSql = "UPDATE musica_curtida SET status = 'descurtiu' WHERE id_usuario = ? AND id_musica = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateSql);
            updateStmt.setInt(1, idUsuario);
            updateStmt.setInt(2, idMusica);
            updateStmt.executeUpdate();
            updateStmt.close();
        } else {
            String insertSql = "INSERT INTO musica_curtida (id_usuario, id_musica, status) VALUES (?, ?, 'descurtiu')";
            PreparedStatement insertStmt = con.prepareStatement(insertSql);
            insertStmt.setInt(1, idUsuario);
            insertStmt.setInt(2, idMusica);
            insertStmt.executeUpdate();
            insertStmt.close();
        }

        rs.close();
        checkStmt.close();
        con.close();
    }

    public boolean isCurtida(int idUsuario, int idMusica) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM musica_curtida WHERE id_usuario = ? AND id_musica = ? AND status = 'curtiu'";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idMusica);
        ResultSet rs = stmt.executeQuery();
        boolean curtida = rs.next();
        rs.close();
        stmt.close();
        con.close();
        return curtida;
    }
}