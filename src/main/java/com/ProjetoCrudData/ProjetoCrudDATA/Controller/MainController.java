package com.ProjetoCrudData.ProjetoCrudDATA.Controller;


import com.ProjetoCrudData.ProjetoCrudDATA.ORM.Login.Login;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import com.ProjetoCrudData.ProjetoCrudDATA.Service.CreateUsers.CreateADM;
import com.ProjetoCrudData.ProjetoCrudDATA.Service.CreateUsers.CreateClient;
import com.ProjetoCrudData.ProjetoCrudDATA.Service.CreateUsers.CreateEmployee;
import com.ProjetoCrudData.ProjetoCrudDATA.Service.Read;
import com.ProjetoCrudData.ProjetoCrudDATA.Service.Delete;
import com.ProjetoCrudData.ProjetoCrudDATA.Service.Update;
import com.ProjetoCrudData.ProjetoCrudDATA.View.Menus;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component // Indica que esta classe é um componente gerenciado pelo Spring
public class MainController {

    // Scanner para entrada de dados do usuário
    private final Scanner scanner = new Scanner(System.in);

    // Declaração de objetos de serviços usados no controlador
    private final CreateADM createAdm;
    private final CreateEmployee createEmployee;
    private final CreateClient createClient;
    private final Delete delete;
    private final Read read;
    private final Update update;
    private final Menus menus;
    private final Login login;

    // Construtor com injeção de dependências
    public MainController(CreateADM createAdm, CreateEmployee createEmployee, CreateClient createClient, Delete delete, Read read, Update update, Menus menus, Login login) {
        this.createAdm = createAdm;
        this.createEmployee = createEmployee;
        this.createClient = createClient;
        this.delete = delete;
        this.read = read;
        this.update = update;
        this.menus = menus;
        this.login = login;
    }

    // Metodo principal que controla o fluxo do programa
    public void controllerMain() {
        boolean exit = true; // Variável que controla a saída do programa

        // Loop principal do controlador
        while (exit) {
            menus.Login(); // Exibe o menu de login
            int optionLogin = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            // Controla as opções selecionadas no menu de login
            switch (optionLogin) {
                case 1:
                    // Realiza o login e determina o tipo de usuário
                    UserType userType = login.login();

                    // Caso o usuário seja ADMIN_MASTER
                    if (userType == UserType.ADMIN_MASTER) {
                        boolean exitMenuAdmn = true;
                        while (exitMenuAdmn) {
                            menus.menuAdmin(); // Exibe o menu de administrador
                            int optionADM = scanner.nextInt();
                            scanner.nextLine(); // Limpa o buffer do scanner

                            // Controla as opções do menu do administrador
                            switch (optionADM) {
                                case 1:
                                    createAdm.createAdmin(); // Cria um novo administrador
                                    break;
                                case 2:
                                    createEmployee.createEmployee(); // Cria um novo funcionário
                                    break;
                                case 3:
                                    createClient.createClient(); // Cria um novo cliente
                                    break;
                                case 4:
                                    read.seeALL(); // Mostra todos os usuários
                                    break;
                                case 5:
                                    read.seeById(); // Busca um usuário por ID
                                    break;
                                case 6:
                                    update.updateById(); // Atualiza um usuário pelo ID
                                    break;
                                case 7:
                                    delete.deleteById(); // Exclui um usuário pelo ID
                                    break;
                                case 0:
                                    exitMenuAdmn = false; // Sai do menu de administrador
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente."); // Opção inválida
                                    break;
                            }
                        }
                    }

                    // Caso o usuário seja Employee
                    if (userType == UserType.Employee) {
                        boolean exitMenuEmployee = true;
                        while (exitMenuEmployee) {
                            menus.menuEmployee(); // Exibe o menu de funcionários
                            int optionEmployee = scanner.nextInt();
                            scanner.nextLine(); // Limpa o buffer do scanner

                            // Controla as opções do menu de funcionários
                            switch (optionEmployee) {
                                case 1:
                                    createEmployee.createEmployee(); // Cria um novo funcionário
                                    break;
                                case 2:
                                    createClient.createClient(); // Cria um novo cliente
                                    break;
                                case 3:
                                    read.seeByClient(); // Visualiza clientes por tipo
                                    break;
                                case 4:
                                    update.updateByType(); // Atualiza tipos de usuários
                                    break;
                                case 5:
                                    delete.deleteByType(); // Exclui usuários por tipo
                                    break;
                                case 0:
                                    exitMenuEmployee = false; // Sai do menu de funcionários
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente."); // Opção inválida
                                    break;
                            }
                        }
                    }

                    // Caso o usuário seja Client
                    if (userType == UserType.Client) {
                        boolean exitMenuClient = true;
                        while (exitMenuClient) {
                            menus.menuClient(); // Exibe o menu de clientes
                            int optionMenuClient = scanner.nextInt();
                            scanner.nextLine(); // Limpa o buffer do scanner

                            // Controla as opções do menu de clientes
                            switch (optionMenuClient) {
                                case 1:
                                    System.out.println("Esse é um CRUD feito com Spring Data, MySQL, JDBC e JPA. Muito contente em mostrar meu avanço dia a pós dia na linguagem Java!");
                                    break;
                                case 0:
                                    exitMenuClient = false; // Sai do menu de clientes
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente."); // Opção inválida
                                    break;
                            }
                        }
                    }
                    break;

                case 2:
                    createClient.createClient(); // Cria um novo cliente diretamente
                    break;

                case 3:
                    exit = false; // Encerra o programa
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente."); // Opção inválida
                    break;
            }
        }
    }
}

