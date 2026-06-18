package com.loja.model;

import java.math.BigDecimal;

public class Multa {
    private String id;
    private ContratoAluguel contrato;
    private String motivo;
    private BigDecimal valorDiario;
    private BigDecimal valorTotal;
    private int diasAtraso;
    private String status;

    public Multa(String id, ContratoAluguel contrato, String motivo, BigDecimal valorDiario, int diasAtraso, String status){
        this.id = id;
        this.contrato = contrato;
        this.motivo = motivo;
        this.valorDiario = valorDiario;
        this.diasAtraso = diasAtraso;
        this.status = status;
        this.valorTotal = valorDiario.multiply(BigDecimal.valueOf(diasAtraso)); // multiplica o bigdecimal por um int
    }

    public String getId(){
        return id;
    }
    public ContratoAluguel getContrato(){
        return contrato;
    }
    public String getMotivo(){
        return motivo;
    }
    public BigDecimal getValorDiario() {
        return valorDiario;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public int getDiasAtraso(){
        return diasAtraso;
    }
    public String getStatus(){
        return status;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setContrato(ContratoAluguel contrato){
        this.contrato = contrato;
    }
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
    public void setValorDiario(BigDecimal valorDiario) {
        this.valorDiario = valorDiario;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setDiasAtras(int diasAtraso){
        this.diasAtraso = diasAtraso;
    }
    public void setStatus(String status){
        this.status = status;
    }
}