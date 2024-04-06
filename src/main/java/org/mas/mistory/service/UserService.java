package org.mas.mistory.service;

import org.mas.mistory.dto.AddUserRequest;
import org.mas.mistory.entity.User;
import org.mas.mistory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; // User 리포지터리 객체 주입

    public User save(AddUserRequest request) {
        return userRepository.save(request.toEntity());
    }

}
