package com.ProjetoCrudData.ProjetoCrudDATA.Service;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class Read {
    private final UserRepository userRepository; // Dependência para acesso ao banco de dados

    // Construtor para injeção do repositório de usuários
    public Read(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metodo para exibir todos os usuários cadastrados no banco de dados
    public void seeALL() {
        Iterable<User> users = this.userRepository.findAll(); // Obtém todos os usuários
        users.forEach(user -> System.out.println(user)); // Exibe cada usuário encontrado
    }

    // Metodo para exibir um usuário específico com base no ID fornecido
    public void seeById(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the ID to view: ");
        Long id = scanner.nextLong();

        // Busca o usuário pelo ID no banco de dados
        Optional<User> users = this.userRepository.findById(id);

        // Se o usuário existir, exibe as informações
        if(users.isPresent()){
            System.out.println(users.get());
        }else{
            System.out.println("The user with ID " + id + " was not found.");
        }

    }
    // Metodo para exibir apenas usuários do tipo "Client"
    public void seeByClient(){
        List<User> users = this.userRepository.findByUserType(UserType.Client);

        if(users != null && !users.isEmpty()) {
            users.forEach(System.out::println); // Exibe todos os clientes
        } else {
            System.out.println("No users of type CLIENT were found.");
        }
    }



}
