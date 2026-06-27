package com.loja.business;

import com.loja.business.interfaces.IItemBusiness;
import com.loja.model.Categoria;
import com.loja.model.Item;
import com.loja.repositories.interfaces.ICategoriaRepository;
import com.loja.repositories.interfaces.IItemRepository;

import java.util.Map;

public class ItemBusiness implements IItemBusiness {
    private IItemRepository repo;
    private ICategoriaRepository catRepo;

    public ItemBusiness(IItemRepository repo, ICategoriaRepository catRepo){
        this.repo = repo;
        this.catRepo = catRepo;
    }

    public void cadastrar(Item i){
        repo.salvar(i);
    };

    public Item buscar(String id){
        return repo.buscar(id);
    };

    public Map<String, Item> listar(){
        return repo.listar();
    };

    public Map<String, Item> listarPorStatus(String status){
        return repo.listar(status);
    };

    public Map<String, Item> listarPorCategoria(Categoria categoria){
        return repo.listar(categoria);
    };

    public void atualizar(Item item){
        repo.atualizar(item);
    };

    public void deletar(String id){
        repo.deletar(id);
    };

}
