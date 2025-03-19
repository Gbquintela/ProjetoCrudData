package com.ProjetoCrudData.ProjetoCrudDATA.Service;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Scanner;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class Delete {
    private final UserRepository userRepository; // Dependência para acesso ao banco de dados
    private final Read read; // Dependência para exibição de dados antes da exclusão

    // Construtor para injetar as dependências necessárias
    public Delete(UserRepository userRepository, Read read){
        this.userRepository = userRepository;
        this.read = read;
    }

    // Metodo para deletar um usuário pelo ID informado
    public void deleteById(){
        Scanner scanner = new Scanner(System.in);

        // Exibe todos os usuários antes de solicitar a exclusão
        read.seeALL();

        System.out.println("Enter the ID for delete: ");
        Long id = scanner.nextLong();

        // Exclui o usuário do banco de dados com base no ID informado
        this.userRepository.deleteById(id);
        System.out.println("Deleted!");
    }

    @Transactional // Garante que a operação seja realizada dentro de uma transação
    public void deleteByType() {
        Scanner scanner = new Scanner(System.in);
        read.seeByClient();
        System.out.println("Enter the ID to delete : ");
        Long id = scanner.nextLong();

        // Busca o usuário no banco de dados pelo ID
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            System.out.println("User found: " + user);
            System.out.println("User type: " + user.getUserType());

            // Valida o tipo de usuário antes de excluir
            if (user.getUserType() == com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType.Client) {
                userRepository.deleteById(id); // Exclui o usuário pelo ID
                System.out.println("Client deleted successfully!");
            }
        } else {
            System.out.println("User with ID " + id + " not found.");
        }
    }

}
