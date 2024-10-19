package com.galata.codingapp.controller;

import com.galata.codingapp.model.User;
import com.galata.codingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private UserService userService;

   @GetMapping
   public List<User> getAllUsers(){
       return userService.getAllUsers();
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id){
       Optional<User> user = userService.getUserById(id);
       return user.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
   }

   @PostMapping
   public ResponseEntity<User> createUser(@RequestBody User user){
       User createdUser = userService.createUser(user);
       return ResponseEntity.ok(createdUser);
   }

   @PutMapping("/{id}")
   public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User updatedUser){
       try {
           User user = userService.updateUser(id, updatedUser);
           return ResponseEntity.ok(user);
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id){
       try{
           userService.deleteUser(id);
           return ResponseEntity.noContent().build();
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }
}
