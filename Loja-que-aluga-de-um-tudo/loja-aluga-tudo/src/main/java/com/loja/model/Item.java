package com.loja.model;

public class Item {
    private String id;
    private String nome;
    private double taxaDiaria;
    private double valorReposicao;
    private String status;
    private Categoria categoria;
    private Fornecedor fornecedor;

    public Item(String id, String nome, double taxaDiaria, double valorReposicao, String status, Categoria categoria, Fornecedor fornecedor){
        this.id = id;
        this.nome = nome;
        this.taxaDiaria = taxaDiaria;
        this.valorReposicao = valorReposicao;
        this.status = status;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
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

    public double getTaxaDiaria() {
        return taxaDiaria;
    }

    public void setTaxaDiaria(double taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    public double getValorReposicao() {
        return valorReposicao;
    }

    public void setValorReposicao(double valorReposicao) {
        this.valorReposicao = valorReposicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
}

