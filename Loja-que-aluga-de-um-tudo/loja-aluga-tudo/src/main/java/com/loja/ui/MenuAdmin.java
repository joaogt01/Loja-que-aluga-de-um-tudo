package com.loja.ui;

import com.loja.padraoFacade.interfaces.ILojaFacade;
import com.loja.model.Administrador;
import com.loja.model.Funcionario;
import com.loja.model.Cliente;
import com.loja.model.Item;
import com.loja.model.Categoria;
import com.loja.model.Fornecedor;
import com.loja.model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuAdmin {

    private final ILojaFacade facade;
    private final Administrador usuarioLogado;
    private final Scanner scanner;

    public MenuAdmin(ILojaFacade facade, Administrador usuarioLogado) {
        this.facade = facade;
        this.usuarioLogado = usuarioLogado;
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        boolean ativo = true;
        while (ativo) {
            System.out.println("\n=== PAINEL ADMINISTRATIVO: " + usuarioLogado.getNome().toUpperCase() + " ===");
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Itens");
            System.out.println("3 - Gerenciar Categorias");
            System.out.println("4 - Gerenciar Fornecedores");
            System.out.println("5 - Emitir Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                gerenciarUsuarios();
            } else if (opcao.equals("2")) {
                gerenciarItens();
            } else if (opcao.equals("3")) {
                gerenciarCategorias();
            } else if (opcao.equals("4")) {
                gerenciarFornecedores();
            } else if (opcao.equals("5")) {
                emitirRelatorios();
            } else if (opcao.equals("0")) {
                System.out.println("Saindo do painel administrativo...");
                ativo = false;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void gerenciarUsuarios() {
        System.out.println("\nGERENCIAR USUÁRIOS");
        System.out.println("1 - Cadastrar Usuário (Cliente/Func/Adm)");
        System.out.println("2 - Listar Usuários");
        System.out.println("3 - Atualizar Usuário");
        System.out.println("4 - Desativar Usuário");
        System.out.print("Escolha uma opção: ");
        String subOpcao = scanner.nextLine();

        try {
            if (subOpcao.equals("1")) {
                System.out.println("Tipo: 1-Cliente | 2-Funcionário | 3-Administrador");
                System.out.print("Escolha o tipo: ");
                String tipo = scanner.nextLine();
                
                System.out.print("ID: ");
                String id = scanner.nextLine();
                
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                
                System.out.print("Email/Login: ");
                String email = scanner.nextLine();
                
                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                if (tipo.equals("1")) {
                    facade.cadastrarCliente(new Cliente(id, nome, email, senha));
                    System.out.println("Cliente cadastrado com sucesso!");
                } else if (tipo.equals("2")) {
                    System.out.print("Cargo do Funcionário: ");
                    String cargo = scanner.nextLine();
                    facade.cadastrarFuncionario(new Funcionario(id, nome, email, senha, cargo));
                    System.out.println("Funcionário cadastrado com sucesso!");
                } else if (tipo.equals("3")) {
                    facade.cadastrarAdm(new Administrador(id, nome, email, senha));
                    System.out.println("Administrador cadastrado com sucesso!");
                } else {
                    System.out.println("Tipo de usuário inválido!");
                }

            } else if (subOpcao.equals("2")) {
                System.out.println("1-Todos | 2-Por Perfil (CLIENTE/FUNCIONARIO/ADMINISTRADOR)");
                System.out.print("Opção: ");
                String listOpt = scanner.nextLine();
                
                if (listOpt.equals("1")) {
                    facade.listarUsuario().values().forEach(u -> System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Perfil: " + u.getPerfil()));
                } else if (listOpt.equals("2")) {
                    System.out.print("Perfil desejado: ");
                    String perfil = scanner.nextLine().toUpperCase();
                    facade.listarUsuarioPorPerfil(perfil).values().forEach(u -> System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome()));
                }

            } else if (subOpcao.equals("3")) {
                System.out.print("ID do usuário a atualizar: ");
                String id = scanner.nextLine();
                
                Usuario u = facade.buscarUsuario(id);
                System.out.print("Novo Nome (" + u.getNome() + "): ");
                u.setNome(scanner.nextLine());
                
                facade.atualizarUsuario(id, u);
                System.out.println("Usuário atualizado com sucesso!");

            } else if (subOpcao.equals("4")) {
                System.out.print("ID do usuário a desativar: ");
                String id = scanner.nextLine();
                facade.desativarUsuario(id);
                System.out.println("Usuário desativado com sucesso.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void gerenciarItens() {
        System.out.println("\nGERENCIAR ITENS");
        System.out.println("1 - Cadastrar Item");
        System.out.println("2 - Listar Itens");
        System.out.println("3 - Atualizar Item");
        System.out.println("4 - Deletar Item");
        System.out.print("Escolha uma opção: ");
        String subOpcao = scanner.nextLine();

        try {
            if (subOpcao.equals("1")) {
                Item item = new Item();
                
                System.out.print("ID: ");
                item.setId(scanner.nextLine());
                
                System.out.print("Nome: ");
                item.setNome(scanner.nextLine());
                
                item.setStatus("DISPONIVEL");
                
                System.out.print("ID Categoria: ");
                item.setCategoria(facade.buscarCategoria(scanner.nextLine()));
                
                System.out.print("ID Fornecedor: ");
                item.setFornecedor(facade.buscarFornecedor(scanner.nextLine()));
                
                facade.cadastrarItem(item);
                System.out.println("Item cadastrado!");

            } else if (subOpcao.equals("2")) {
                System.out.println("1-Todos | 2-Por Status | 3-Por Categoria | 4-Por Fornecedor");
                System.out.print("Opção: ");
                String opt = scanner.nextLine();
                
                if (opt.equals("1")) {
                    facade.listarItem().values().forEach(i -> System.out.println("ID: " + i.getId() + " | Nome: " + i.getNome() + " | Status: " + i.getStatus()));
                } else if (opt.equals("2")) {
                    System.out.print("Status (DISPONIVEL/ALUGADO): ");
                    String status = scanner.nextLine().toUpperCase();
                    facade.listarItemPorStatus(status).values().forEach(i -> System.out.println("ID: " + i.getId() + " | Nome: " + i.getNome()));
                } else if (opt.equals("3")) {
                    System.out.print("ID Categoria: ");
                    Categoria cat = facade.buscarCategoria(scanner.nextLine());
                    facade.listarItemPorCategoria(cat).values().forEach(i -> System.out.println("ID: " + i.getId() + " | Nome: " + i.getNome()));
                } else if (opt.equals("4")) {
                    System.out.print("ID Fornecedor: ");
                    Fornecedor forn = facade.buscarFornecedor(scanner.nextLine());
                    facade.listarItemPorFornecedor(forn).values().forEach(i -> System.out.println("ID: " + i.getId() + " | Nome: " + i.getNome()));
                }

            } else if (subOpcao.equals("3")) {
                System.out.print("ID do Item: ");
                Item item = facade.buscarItem(scanner.nextLine());
                
                System.out.print("Novo Nome: ");
                item.setNome(scanner.nextLine());
                
                facade.atualizarItem(item);
                System.out.println("Item updated com sucesso!");

            } else if (subOpcao.equals("4")) {
                System.out.print("ID do Item a deletar: ");
                facade.deletarItem(scanner.nextLine());
                System.out.println("Item deletado do repositório.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void gerenciarCategorias() {
        System.out.println("\nGERENCIAR CATEGORIAS");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.print("Opção: ");
        String subOpcao = scanner.nextLine();

        try {
            if (subOpcao.equals("1")) {
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                facade.cadastrarCategoria(new Categoria(id, nome));
                System.out.println("Categoria criada!");
                
            } else if (subOpcao.equals("2")) {
                facade.listarCategoria().values().forEach(c -> System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome()));
                
            } else if (subOpcao.equals("3")) {
                System.out.print("ID: ");
                Categoria c = facade.buscarCategoria(scanner.nextLine());
                System.out.print("Novo Nome: ");
                c.setNome(scanner.nextLine());
                facade.atualizarCategoria(c);
                System.out.println("Categoria atualizada!");
                
            } else if (subOpcao.equals("4")) {
                System.out.print("ID a deletar: ");
                facade.deletarCategoria(scanner.nextLine());
                System.out.println("Categoria removida.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void gerenciarFornecedores() {
        System.out.println("\nGERENCIAR FORNECEDORES");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.print("Opção: ");
        String subOpcao = scanner.nextLine();

        try {
            if (subOpcao.equals("1")) {
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                
                Fornecedor f = new Fornecedor();
                f.setId(id);
                f.setNome(nome);
                
                facade.cadastrarFornecedor(f);
                System.out.println("Fornecedor criado!");
                
            } else if (subOpcao.equals("2")) {
                facade.listarFornecedor().values().forEach(f -> System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome()));
                
            } else if (subOpcao.equals("3")) {
                System.out.print("ID: ");
                Fornecedor f = facade.buscarFornecedor(scanner.nextLine());
                System.out.print("Novo Nome: ");
                f.setNome(scanner.nextLine());
                facade.atualizarFornecedor(f);
                System.out.println("Fornecedor atualizado!");
                
            } else if (subOpcao.equals("4")) {
                System.out.print("ID a deletar: ");
                facade.deletarFornecedor(scanner.nextLine());
                System.out.println("Fornecedor removido.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void emitirRelatorios() {
        System.out.println("\nEMITIR RELATÓRIOS");
        System.out.println("1 - Itens Disponíveis");
        System.out.println("2 - Aluguéis Atuais (Ativos)");
        System.out.println("3 - Aluguel de um Cliente (Histórico)");
        System.out.println("4 - Financeiro (Faturamento)");
        System.out.print("Opção: ");
        String subOpcao = scanner.nextLine();

        try {
            if (subOpcao.equals("1")) {
                facade.listarItensDisponiveis().values().forEach(i -> System.out.println("ID: " + i.getId() + " | Nome: " + i.getNome()));
            } else if (subOpcao.equals("2")) {
                facade.listarContratosAtivos().values().forEach(c -> System.out.println("Contrato ID: " + c.getId() + " | Cliente ID: " + c.getCliente().getId()));
            } else if (subOpcao.equals("3")) {
                System.out.print("ID do Cliente: ");
                String clienteId = scanner.nextLine();
                facade.consultarHistoricoCliente(clienteId).values().forEach(c -> System.out.println("Contrato ID: " + c.getId() + " | Status: " + c.getStatus()));
            } else if (subOpcao.equals("4")) {
                System.out.print("Data Inicial (AAAA-MM-DD): ");
                LocalDate ini = LocalDate.parse(scanner.nextLine());
                System.out.print("Data Final (AAAA-MM-DD): ");
                LocalDate fim = LocalDate.parse(scanner.nextLine());
                System.out.println(facade.gerarRelatorioFaturamento(ini, fim));
            }
        } catch (Exception e) {
            System.out.println("Erro ao emitir relatório: " + e.getMessage());
        }
    }
}