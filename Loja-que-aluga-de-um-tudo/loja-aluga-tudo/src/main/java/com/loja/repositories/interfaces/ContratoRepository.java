package com.loja.repositories.interfaces;

import com.loja.model.ContratoAluguel;

import java.util.List;
import java.util.Map;

public interface ContratoRepository {
    void salvar(ContratoAluguel contrato);
    ContratoAluguel buscar(String id);

    Map<String, ContratoAluguel> listar();
    Map<String, ContratoAluguel> listarPorCliente(String clienteId);
    Map<String, ContratoAluguel> listarPorStatus(String status);

    void atualizar(String id);
    void deletar(String id);

    void carregarDados();
    void salvarDados();
}
