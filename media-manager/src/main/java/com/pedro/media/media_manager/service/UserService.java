package com.pedro.media.media_manager.service;

import com.pedro.media.media_manager.dto.UserRegisterDTO;
import com.pedro.media.media_manager.model.User;
import com.pedro.media.media_manager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(UserRegisterDTO dto) {
        if(userRepository.findByName(dto.getName()).isPresent()) {
            throw new RuntimeException("try again, otario");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(List.of("USER")); // padrão

        return userRepository.save(user);
    }
}
