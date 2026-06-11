package com.loja.model;

public class Fornecedor {
    private String id;
    private String razaoSocial;
    private String cnpj;

    public Fornecedor(String id, String razaoSocial, String cnpj){
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getId(){
        return this.id;
    }

    public String getRazaoSocial(){
        return this.razaoSocial;
    }

    public String getCnpj(){
        return this.cnpj;
        
    }
}
