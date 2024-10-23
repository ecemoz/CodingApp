package com.galata.codingapp.service;

import com.galata.codingapp.model.User;
import com.galata.codingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                        user.setUsername(updatedUser.getUsername());
                        user.setEmail(updatedUser.getEmail());
                        user.setPassword(updatedUser.getPassword());
                        user.setScore(updatedUser.getScore());
                        user.setLevel(updatedUser.getLevel());
                        return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

//    updateUser function with if else
//    public User updateUser(Long id, User updatedUser) {
//        Optional<User> existingUser = userRepository.findById(id);
//        if (existingUser.isPresent()) {
//            User user = existingUser.get();
//            user.setUsername(updatedUser.getUsername());
//            user.setEmail(updatedUser.getEmail());
//            user.setPassword(updatedUser.getPassword());
//            user.setScore(updatedUser.getScore());
//            user.setLevel(updatedUser.getLevel());
//            return userRepository.save(user);
//        } else {
//            throw new RuntimeException("User not found");
//        }
//    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public boolean authenticate (String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }
}
