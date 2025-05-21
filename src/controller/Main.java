package controller;

import dao.UsuarioDAO;
import dao.MusicaDAO;
import model.Usuario;
import model.Musica;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            
            Usuario usuario = new Usuario("Joao", "joao@email.com", "123");
            UsuarioDAO udao = new UsuarioDAO();
            udao.cadastrar(usuario);
            
            Usuario logado = udao.validarLogin("joao@email.com", "123");
            System.out.println("Logado como: " + logado.getNome());
            
            MusicaDAO mdao = new MusicaDAO();

            List<Musica> musicas = mdao.buscar("shape", "nome");
            for (Musica m : musicas) {
                System.out.println("Música encontrada: " + m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}