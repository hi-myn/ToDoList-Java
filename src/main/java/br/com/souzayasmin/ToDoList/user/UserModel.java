package br.com.souzayasmin.ToDoList.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

//estrutura básica da entidade
@Data
@Entity(name ="tb_users")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true) //coluna com restrição- atributo unico
    private String username;
    private String name;
    private String password;

    //quando o tributo foi criado
    @CreationTimestamp
    private LocalDateTime creatdAt;

}
