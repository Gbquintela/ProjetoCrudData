package com.ProjetoCrudData.ProjetoCrudDATA.ORM.Login;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import com.ProjetoCrudData.ProjetoCrudDATA.Repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
@Component
public class Login {

    private final UserRepository userRepository;
    public Login(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserType login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter nickname: ");
        String nickname = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Optional<User> optionalUser = userRepository.findByNickname(nickname);

        if(optionalUser.isPresent()){ // Verifica se o usuário foi encontrado no banco
            User user = optionalUser.get();

            if(user.getPassword().equals(password)){ // Verifica se a senha está correta
                System.out.println("Login successfully!");
                return user.getUserType(); // Retorna o tipo de usuário autenticado
            } else {
                System.out.println("Password is incorrect.");
            }
        } else {
            System.out.println("User not found.");
        }

        return null; // Retorna null caso o login falhe
    }
}