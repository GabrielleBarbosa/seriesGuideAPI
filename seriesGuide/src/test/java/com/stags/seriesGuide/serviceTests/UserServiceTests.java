package com.stags.seriesGuide.serviceTests;


import com.stags.seriesGuide.entity.User;
import com.stags.seriesGuide.models.UserRequest;
import com.stags.seriesGuide.repository.UserRepository;
import com.stags.seriesGuide.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    public void shouldReturnCreatedUser(){
        UserRequest userRequest = new UserRequest(1, "", "", "Joao");
        when(repository.save(any(User.class))).thenReturn(new User().setName(userRequest.getName()));
        User created = service.saveUser(userRequest);
        assertEquals(userRequest.getName(), created.getName());
    }

    @Test
    public void shouldReturnUserByEmail(){
        String email = "teste@teste.com";
        when(repository.findByEmail(any(String.class))).thenReturn(new User().setEmail(email));
        User response = service.getUserByEmail(email);
        assertEquals(email, response.getEmail());
    }
}
