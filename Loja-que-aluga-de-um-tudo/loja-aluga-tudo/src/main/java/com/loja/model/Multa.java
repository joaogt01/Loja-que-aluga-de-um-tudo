package com.loja.model;

public class Multa {
    private String id;
    private double valor;
    private String motivo;
    private boolean paga;

    public Multa(){

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public String getMotivo(){
        return motivo;
    }

    public void setMotivo(String motivo){
        this.motivo = motivo;
    }

    public boolean isPaga(){
        return paga;
    }

    public void setPaga(boolean paga){
        this.paga = paga;
    }
}