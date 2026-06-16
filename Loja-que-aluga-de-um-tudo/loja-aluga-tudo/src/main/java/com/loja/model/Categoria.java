package com.loja.model;

public class Categoria {
    private String id;
    private String nome;
    private boolean ativa;

    public Categoria(String id, String nome, boolean ativa){
        this.id = id;
        this.nome = nome;
        this.ativa = ativa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
