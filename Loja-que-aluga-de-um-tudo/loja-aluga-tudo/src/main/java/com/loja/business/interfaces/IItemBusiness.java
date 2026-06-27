package com.loja.business.interfaces;
import com.loja.model.Categoria;
import com.loja.model.Item;

import java.util.Map;

public interface IItemBusiness {
    public void cadastrar(Item i);

    public Item buscar(String id);

    public Map<String, Item> listar();

    public Map<String, Item> listarPorStatus(String status);

    public Map<String, Item> listarPorCategoria(Categoria categoria);

    public void atualizar(Item item);

    public void deletar(String id);

}
