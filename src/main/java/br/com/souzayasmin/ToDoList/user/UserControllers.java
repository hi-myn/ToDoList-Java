package br.com.souzayasmin.ToDoList.user;
//tudo que for relacionado ao usuário vai ser acessado aqui


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserControllers {
    @Autowired //todo ciclo de vida, o spring vai gerenciar
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        //verificando se o username já existe
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        //criptografando a senha
        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
