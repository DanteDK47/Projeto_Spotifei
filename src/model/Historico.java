package model;

public class Historico {
    private int id;
    private int usuarioId;
    private int musicaId;

    public Historico() {}

    public Historico(int usuarioId, int musicaId) {
        this.usuarioId = usuarioId;
        this.musicaId = musicaId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public int getMusicaId() { return musicaId; }
    public void setMusicaId(int musicaId) { this.musicaId = musicaId; }
}