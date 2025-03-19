package com.ProjetoCrudData.ProjetoCrudDATA.Service.CreateUsers;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class CreateADM {
    private final UserRepository userRepository; // Dependência do repositório para salvar usuários no banco

    // Construtor para injetar o UserRepository no serviço
    public CreateADM(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Metodo para criar um usuário administrador
    public void createAdmin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to menu Register!");

        // Captura os dados do novo administrador via entrada do usuário
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your CPF: ");
        String CPF = scanner.nextLine();

        System.out.println("Enter your Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your nickname: ");
        String nickname = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // Cria um novo objeto User com tipo ADMIN_MASTER
        User users = new User(CPF, UserType.ADMIN_MASTER, nickname, password, name, email);

        // Salva o usuário no banco de dados
        this.userRepository.save(users);

        System.out.println("User created");
    }
}
