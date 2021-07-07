package com.manriquetavi.miscontactos;

public class Contacto {
    private String id;
    private String urlFoto;
    private int likes = 0;

    public Contacto(String urlFoto, int likes) {
        this.urlFoto = urlFoto;
        this.likes = likes;
    }

    public Contacto() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
