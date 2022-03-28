package com.example.Thesis;

import com.example.Thesis.Enums.UserRol;
import com.example.Thesis.Exceptions.EmailConfirmedException;
import com.example.Thesis.Exceptions.UserNotFoundException;
import com.example.Thesis.Models.User;
import com.example.Thesis.Repositories.UserRepository;
import com.example.Thesis.Services.ConfirmationTokenService;
import com.example.Thesis.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.event.annotation.PrepareTestInstance;

import java.security.Provider;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private ConfirmationTokenService confirmationTokenService;

    @InjectMocks
    private UserService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void CheckIfTheUserAlreadyExists() {
        //setup - data
        User user = new User("Andres",
                "Gomez",
                "1144090825",
                "address",
                "77777",
                "cali",
                "valle del cauca",
                "colombia",
                "af.gomez@globant.com",
                "admin123",
                UserRol.USER);

        //setup - expectations
        Mockito.when(repository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        //Service
        EmailConfirmedException exception = assertThrows(EmailConfirmedException.class, () -> service.signUpUser(user));
        //validation
        Assertions.assertEquals("The email is already in use\"af.gomez@globant.com\"", exception.getMessage());
    }

    @Test
    public void CheckIfTheUserIsLoadedByEmail() {
        //setup - data
        User user = new User("Andres",
                "Gomez",
                "1144090825",
                "address",
                "77777",
                "cali",
                "valle del cauca",
                "colombia",
                "af.gomezzz@globant.com",
                "admin123",
                UserRol.USER);
        //setup - expectations
        Mockito.when(repository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        //Service
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> service.loadUserByUsername(user.getEmail()));
        //validation
        Assertions.assertEquals("The user " + user.getEmail() + " does not exist", exception.getMessage());
    }

    @Test
    public void CheckIfTheAdminUsersAreCreated() {
        //setup - data
        CharSequence charSequence = "admin123";
        String password = bCryptPasswordEncoder.encode(charSequence);

        User user1 = User.builder()
                .email("andres.rey@globant.com")
                .firstName("Andres")
                .lastName("Rey")
                .password(password)
                .userRol(UserRol.ADMIN)
                .locked(false)
                .enabled(true)
                .build();
        User user2 = User.builder()
                .email("af.gomez@globant.com")
                .firstName("Andres")
                .lastName("Gomez")
                .password(password)
                .userRol(UserRol.ADMIN)
                .locked(false)
                .enabled(true)
                .build();

        //setup - expectations
        Mockito.when(repository.findByEmail(user1.getEmail())).thenReturn(Optional.of(user1));
        Mockito.when(repository.findByEmail(user2.getEmail())).thenReturn(Optional.of(user2));
        //Service
        service.createAdminprofiles();


        //validation
        assertAll(
                () -> Assertions.assertEquals(user1, repository.findByEmail(user1.getEmail()).get()),
                () -> Assertions.assertEquals(user2, repository.findByEmail(user2.getEmail()).get())
        );
    }

    @Test
    public void CheckIfRegistrationReturnsToken() {
        //setup - data
        User user = new User("Andres",
                "Gomez",
                "1144090825",
                "address",
                "77777",
                "cali",
                "valle del cauca",
                "colombia",
                "af.gomezzz@globant.com",
                "admin123",
                UserRol.USER);
        //setup - expectations
        Mockito.when(repository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        Mockito.when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("password");
        Mockito.when(confirmationTokenService.doSomething()).thenReturn("1");
        //Service
        String test = service.signUpUser(user);
        //validation

        Assertions.assertEquals("1", test);
    }


}