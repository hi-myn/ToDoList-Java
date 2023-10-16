package br.com.souzayasmin.ToDoList.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


//o que contém dentro <> sao atributos mais diâmicos
public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);
}
