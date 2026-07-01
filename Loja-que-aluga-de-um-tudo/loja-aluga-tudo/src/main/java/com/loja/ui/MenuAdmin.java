package com.loja.ui;

import com.loja.model.Administrador;
import com.loja.padraoFacade.interfaces.ILojaFacade;

import java.util.Scanner;

public class MenuAdmin {
    private final ILojaFacade facade;
    private final Administrador usuarioLogado;
    private final Scanner scanner;

    public MenuAdmin(ILojaFacade facade, Administrador usuarioLogado, Scanner scanner) {
        this.facade = facade;
        this.usuarioLogado = usuarioLogado;
        this.scanner = scanner;
    }
}