package com.ProjetoCrudData.ProjetoCrudDATA.ORM;

import jakarta.persistence.*;

// Anotação @Entity indica que esta classe representa uma entidade do banco de dados
@Entity
// Define o nome da tabela no banco de dados como "Users"
@Table(name = "Users")
public class User {

    // Define a chave primária da tabela com geração automática de valores
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UsersID;

    // Define a coluna "Name" como obrigatória, com no máximo 50 caracteres
    @Column(nullable = false, length = 50)
    private String Name;

    // Define a coluna "CPF" como obrigatória, única e com no máximo 14 caracteres
    @Column(nullable = false, length = 14, unique = true)
    private String CPF;

    // Define a coluna "Email" como obrigatória, única e com no máximo 80 caracteres
    @Column(nullable = false, length = 80, unique = true)
    private String Email;

    // Define a coluna "nickname" como obrigatória, única e com no máximo 50 caracteres
    @Column(nullable = false, length = 50, unique = true)
    private String nickname;

    // Define a coluna "Password" como obrigatória, única e com no máximo 50 caracteres
    @Column(nullable = false, length = 50, unique = true)
    private String Password;

    // Define a coluna "userType" como obrigatória, armazenando o tipo de usuário
    @Column(nullable = false)
    private UserType userType;

    // Construtor padrão sem argumentos (necessário para JPA)
    public User() {
    }

    // Construtor com parâmetros para facilitar a criação de objetos
    public User(String CPF, UserType userType, String nickname, String password, String name, String email) {
        this.CPF = CPF;
        this.userType = userType;
        this.nickname = nickname;
        this.Password = password;
        this.Name = name;
        this.Email = email;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getUsersID() {
        return UsersID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    // Metodo toString() para exibir os atributos do objeto de forma organizada
    @Override
    public String toString() {
        return "User: " +
                "CPF= " + CPF +
                ", UsersID=" + UsersID +
                ", Name= " + Name +
                ", Email= " + Email +
                ", nickname= " + nickname +
                ", Password= " + Password +
                ", User type: " + userType;
    }
}
