package com.stags.seriesGuide.repositoryTests;

import com.stags.seriesGuide.entity.User;
import com.stags.seriesGuide.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    UserRepository repository;

    User mockUser = new User()
            .setEmail("teste@teste.com")
            .setName("Teste")
            .setPassword("teste1234");

    @Test
    public void shoudlSaveAndReturnUser(){

        repository.save(mockUser);
        Integer countUser = repository.findAll().size();
        assertEquals(1, countUser);
    }

    @Test
    public void shouldReturnUserByEmail(){
        repository.save(mockUser);
        User user1 = repository.findByEmail(mockUser.getEmail());
        assertEquals(mockUser.getName(), user1.getName());
    }
}
