package com.lietz.demo.controller;

import com.lietz.demo.model.User;
import com.lietz.demo.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getUsers (){
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id){
    try{
      User user = userService.findUserById(id);
      return ResponseEntity.ok(user);
    }catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user){
    User newUser = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    try{
      userService.deleteUser(id);
      return ResponseEntity.noContent().build();
    }catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }

}
