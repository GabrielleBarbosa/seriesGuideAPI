package com.stags.seriesGuide.service;

import com.stags.seriesGuide.entity.User;
import com.stags.seriesGuide.models.UserRequest;
import com.stags.seriesGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest user){
        User u = new User().setEmail(user.getEmail()).setName(user.getName()).setPassword(user.getPassword()).setId(user.getId());
        return repository.save(u);
    }

    public User getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public User getUserById(long id){
        return repository.findById(id).orElse(null);
    }

}
