package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import dao.Conexao;

public class HistoricoDAO {

    public List<String> buscarUltimasBuscadas(int usuarioId) throws Exception {
        List<String> buscadas = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT m.nome FROM musica m " +
                     "JOIN historico h ON m.id = h.musica_id " +
                     "WHERE h.usuario_id = ? ORDER BY h.data_busca DESC LIMIT 10";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            buscadas.add(rs.getString("nome"));
        }
        rs.close();
        stmt.close();
        con.close();
        return buscadas;
    }

    public List<String> buscarCurtidas(int usuarioId) throws Exception {
        List<String> curtidas = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT nome FROM musica " +
                 "JOIN musica_curtida ON musica.id = musica_curtida.id_musica " +
                 "WHERE musica_curtida.id_usuario = ? AND musica_curtida.status = 'curtiu'";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            curtidas.add(rs.getString("nome"));
        }
        rs.close();
        stmt.close();
        con.close();
        return curtidas;
    }

    public List<String> buscarDescurtidas(int usuarioId) throws Exception {
        List<String> descurtidas = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT m.nome FROM musica m " +
                     "JOIN musica_curtida mc ON m.id = mc.id_musica " +
                     "WHERE mc.id_usuario = ? AND mc.status = 'descurtiu'";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            descurtidas.add(rs.getString("nome"));
        }
        rs.close();
        stmt.close();
        con.close();
        return descurtidas;
    }


    public void registrarBusca(Historico h) throws Exception {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO historico (usuario_id, musica_id, data_busca) VALUES (?, ?, now())";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, h.getUsuarioId());
            stmt.setInt(2, h.getMusicaId());
            stmt.execute();
            stmt.close();
            con.close();
    }}