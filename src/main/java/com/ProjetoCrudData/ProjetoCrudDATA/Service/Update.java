package com.ProjetoCrudData.ProjetoCrudDATA.Service;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class Update {
    private final UserRepository userRepository; // Dependência para interagir com o banco de dados
    private final Read read; // Dependência do serviço de leitura de usuários

    // Construtor para injeção das dependências
    public Update(UserRepository userRepository, Read read) {
        this.userRepository = userRepository;
        this.read = read;
    }

    // Metodo para atualizar um usuário pelo ID
    public void updateById() {
        Scanner scanner = new Scanner(System.in);

        // Exibe todos os usuários antes de solicitar o ID para atualização
        read.seeALL();

        System.out.println("Enter the id for update: ");
        Long id = scanner.nextLong(); // Lê o ID do usuário a ser atualizado

        scanner.nextLine(); // Consome a quebra de linha pendente

        // Busca o usuário no banco de dados pelo ID fornecido
        Optional<User> optional = this.userRepository.findById(id);

        // Verifica se o usuário existe antes de tentar atualizar
        if (optional.isPresent()) {
            System.out.println("Enter the name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the CPF: ");
            String CPF = scanner.nextLine();

            System.out.println("Enter the email: ");
            String email = scanner.nextLine();

            System.out.println("Enter the username: ");
            String nickname = scanner.nextLine();

            System.out.println("Enter the password: ");
            String password = scanner.nextLine();

            // Obtém o usuário existente e atualiza os campos
            User user = optional.get();
            user.setName(name);
            user.setCPF(CPF);
            user.setEmail(email);
            user.setNickname(nickname);
            user.setPassword(password);

            // Salva o usuário atualizado no banco de dados
            userRepository.save(user);

            System.out.println("Update!");
        } else {
            System.out.println("The ID is wrong " + id + " Try Again.");
        }
    }

    // Metodo para atualizar um usuário pelo tipo
    public void updateByType() {
        Scanner scanner = new Scanner(System.in);

        // Busca e exibe todos os usuários do tipo "Client"
        List<User> users = this.userRepository.findByUserType(UserType.Client);
        if (users != null && !users.isEmpty()) {
            users.forEach(user -> System.out.println(user)); // Exibe cada cliente encontrado
        } else {
            System.out.println("No users of type CLIENT were found.");
            return; // Sai do metodo, pois não há usuários a serem atualizados
        }

        System.out.println("Enter the ID for update : ");
        Long id = scanner.nextLong(); // Lê o ID do usuário a ser atualizado

        scanner.nextLine(); // Consome a quebra de linha pendente

        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            System.out.println("Enter the name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the CPF: ");
            String CPF = scanner.nextLine();

            System.out.println("Enter the email: ");
            String email = scanner.nextLine();

            System.out.println("Enter the username: ");
            String nickname = scanner.nextLine();

            System.out.println("Enter the password: ");
            String password = scanner.nextLine();

            User user = optional.get();
            user.setName(name);
            user.setCPF(CPF);
            user.setEmail(email);
            user.setNickname(nickname);
            user.setPassword(password);

            userRepository.save(user);

            System.out.println("User updated!");
        } else {
            System.out.println("The user with ID " + id + " was not found.");
        }
    }
}

