package com.lietz.demo.service;

import com.lietz.demo.model.User;
import com.lietz.demo.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers (){
    return userRepository.findAll();
  }
  public User createUser(User user){
    return userRepository.save(user);
  }

  public User findUserById(Long id){
    return userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("User not found"));
  }

  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }
}
