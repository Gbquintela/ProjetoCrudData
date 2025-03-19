package com.ProjetoCrudData.ProjetoCrudDATA.Service.CreateUsers;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class CreateEmployee {

    private UserRepository userRepository; // Dependência para acessar o banco de dados

    // Construtor para injetar a dependência do UserRepository
    public CreateEmployee(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Metodo responsável por criar um novo funcionário no sistema
    public void createEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to menu Register!");

        // Captura os dados do funcionário via entrada do usuário
        System.out.println("Enter your Name : ");
        String name = scanner.nextLine();

        System.out.println("Enter your CPF: ");
        String CPF = scanner.nextLine();

        System.out.println("Enter your Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your nickname: ");
        String nickname = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // Cria um objeto User com o tipo Employee
        User users = new User(CPF, UserType.Employee, nickname, password, name, email);

        // Salva o novo funcionário no banco de dados
        this.userRepository.save(users);

        System.out.println("Employeed created!");
    }
}
