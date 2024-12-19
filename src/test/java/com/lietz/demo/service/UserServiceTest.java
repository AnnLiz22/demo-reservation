package com.lietz.demo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lietz.demo.model.User;
import com.lietz.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class UserServiceTest {

  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserService userService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldGetAllUsers() {
    List<User> users = List.of(
        new User(1L, "Anna", "ania@anna", "123"),
        new User(2L, "Bartosz", "bartek@bartek", "123"),
        new User(3L, "Hania", "hania@hanna", "123"));

    when(userRepository.findAll()).thenReturn(users);
    userService.getAllUsers();

    Assertions.assertEquals("Anna", users.get(0).getUsername());
    verify(userRepository, times(1)).findAll();
  }

  @Test
  void createUser() {
  }

  @Test
  void shouldFindUserById() {
    User user = new User(5L, "Ania", "kowalska@gmail","1234");
    when(userRepository.findById(5L)).thenReturn(Optional.of(user));
    userService.findUserById(5L);
    Assertions.assertEquals("Ania", user.getUsername());
    Assertions.assertEquals("kowalska@gmail", user.getEmail());
  }

  @Test
  void shouldInvokeDeleteUserFromRepository() {
    userService.deleteUser(1L);
    Mockito.verify(userRepository, times(1)).deleteById(1L);
  }
}