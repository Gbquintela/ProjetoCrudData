package com.ProjetoCrudData.ProjetoCrudDATA.Repository;

import com.ProjetoCrudData.ProjetoCrudDATA.ORM.User;
import com.ProjetoCrudData.ProjetoCrudDATA.ORM.UserType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// Interface que estende CrudRepository para operações CRUD no banco de dados
public interface UserRepository extends CrudRepository<User, Long> {

    // Metodo para buscar um usuário pelo nickname, retornando um Optional<User>
    Optional<User> findByNickname(String nickname);

    // Metodo para buscar um usuário pelo tipo de usuário (UserType)
    List<User> findByUserType(UserType userType);


    // Metodo para deletar um usuário com base no tipo de usuário
    void deleteByUserType(UserType userType);
}
