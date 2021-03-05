package com.stags.seriesGuide.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stags.seriesGuide.controller.UserController;
import com.stags.seriesGuide.entity.User;
import com.stags.seriesGuide.models.UserRequest;
import com.stags.seriesGuide.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    private User mockUser = new User()
            .setId(1)
            .setEmail("teste@teste.com")
            .setName("Teste")
            .setPassword("teste1234");

    @Test
    public void getUserByEmail() throws Exception{
        when(service.getUserByEmail(any(String.class))).thenReturn(mockUser);
        this.mockMvc.perform(get("/users/email/hnv"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockUser.getName())));
    }

    @Test
    public void saveUser() throws Exception{
        when(service.saveUser(any(UserRequest.class))).thenReturn(mockUser);
        this.mockMvc.perform(post("/users")
                .content((new ObjectMapper()).writeValueAsString(mockUser))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetUserById() throws Exception{
        when(service.getUserById(any(Long.class))).thenReturn(mockUser);
        this.mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockUser.getName())));
    }
}
