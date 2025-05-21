/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Playlist;
import model.Musica;
import java.sql.*;
import java.util.*;

public class PlaylistDAO {
    public void cadastrar(Playlist p) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO playlist (usuario_id, nome) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, p.getUsuarioId());
        stmt.setString(2, p.getNome());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public List<Playlist> buscarPorUsuario(int usuarioId) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM playlist WHERE usuario_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();
        List<Playlist> playlists = new ArrayList<>();
        while (rs.next()) {
            Playlist p = new Playlist(rs.getInt("usuario_id"), rs.getString("nome"));
            p.setId(rs.getInt("id"));
            playlists.add(p);
        }
        rs.close();
        stmt.close();
        con.close();
        return playlists;
    }

    public List<Musica> buscarMusicas(int playlistId) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "SELECT m.* FROM musica m JOIN playlist_musica pm ON m.id = pm.musica_id WHERE pm.playlist_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, playlistId);
        ResultSet rs = stmt.executeQuery();
        List<Musica> musicas = new ArrayList<>();
        while (rs.next()) {
            Musica m = new Musica(rs.getString("nome"), rs.getString("artista"), rs.getString("genero"));
            m.setId(rs.getInt("id"));
            musicas.add(m);
        }
        rs.close();
        stmt.close();
        con.close();
        return musicas;
    }

    public void adicionarMusica(int playlistId, int musicaId) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO playlist_musica (playlist_id, musica_id) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, playlistId);
        stmt.setInt(2, musicaId);
        stmt.execute();
        stmt.close();
        con.close();
    }

    public void removerMusica(int playlistId, int musicaId) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM playlist_musica WHERE playlist_id = ? AND musica_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, playlistId);
        stmt.setInt(2, musicaId);
        stmt.execute();
        stmt.close();
        con.close();
    }
}
