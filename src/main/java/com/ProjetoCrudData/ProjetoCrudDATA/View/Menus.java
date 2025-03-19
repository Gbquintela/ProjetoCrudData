package com.ProjetoCrudData.ProjetoCrudDATA.View;

import org.springframework.stereotype.Component;

@Component
public class Menus {
    //Tela Menu Administrativo
    public void menuAdmin(){

        System.out.println("""
                1- Register Admin
                2- Register Employee
                3- Register Client
                4- View all
                5- view by ID
                6- Update by id
                7- Delete by id
                0- Exit
                
                
                """);
    }

    //tela Do Menu Funcionarios
    public void menuEmployee(){
        System.out.println("""
                1- Register Employee
                2- Register Client
                3- Show Client
                4- Update Client
                5- Delete Client
                0- Exit
                """);
    }
    //Tela de Menu do Client
    public void menuClient(){
        System.out.println("""
                1-View
                0-Exit 
                """);
    }
        //Tela de Login
    public void Login(){
        System.out.println("""
                1-login
                2-register
                3-exit
                
                
                """);
    }
}
