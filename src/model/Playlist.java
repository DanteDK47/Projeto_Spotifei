package model;

public class Playlist {
    private int id;
    private String nome;
    private int usuarioId;

    public Playlist(int usuarioId, String nome) {
        this.usuarioId = usuarioId;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

   @Override
    public String toString() {
        return this.getNome();
    }
}