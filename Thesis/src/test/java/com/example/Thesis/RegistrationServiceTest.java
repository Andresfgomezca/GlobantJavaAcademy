package com.example.Thesis;

import com.example.Thesis.Dtos.RegistrationRequest;
import com.example.Thesis.Enums.UserRol;
import com.example.Thesis.Exceptions.EmailNotValidException;
import com.example.Thesis.Exceptions.UserNotFoundException;
import com.example.Thesis.Models.ConfirmationToken;
import com.example.Thesis.Models.EmailSender;
import com.example.Thesis.Models.User;
import com.example.Thesis.Services.ConfirmationTokenService;
import com.example.Thesis.Services.EmailValidator;
import com.example.Thesis.Services.RegistrationService;
import com.example.Thesis.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistrationServiceTest {
    @Mock
    private UserService userService;
    @Mock
    private EmailValidator emailValidator;
    @Mock
    private ConfirmationTokenService confirmationTokenService;
    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private RegistrationService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    public RegistrationServiceTest() {
    }

    @Test
    public void CheckIfEmailIsValidToCreateLink() {
        //setup - data
        RegistrationRequest request = new RegistrationRequest("Andres",
                "Gomez",
                "1144090825",
                "address",
                "77777",
                "cali",
                "valle del cauca",
                "colombia",
                "af.gomez@globaaant.com",
                "admin123");

        //setup - expectations
        Mockito.when(emailValidator.test(request.getEmail())).thenReturn(false);
        //Service
        EmailNotValidException exception = assertThrows(EmailNotValidException.class, () -> service.register(request));
        //validation
        Assertions.assertEquals("The email is not valid, the domain must be from globant.com"
                + "\"" + request.getEmail() + "\"", exception.getMessage());
    }

    @Test
    public void CheckIfTheEmailIsBuildCorrectly() {
        //setup - data
        RegistrationRequest request = new RegistrationRequest("Andres",
                "Gomez",
                "1144090825",
                "address",
                "77777",
                "cali",
                "valle del cauca",
                "colombia",
                "af.gomez@globant.com",
                "admin123");
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
        Mockito.when(emailValidator.test(request.getEmail())).thenReturn(true);
        Mockito.when(userService.enableUser(request.getEmail())).thenReturn(1);
        //token will be "1"
        Mockito.when(userService.signUpUser(User.builder().build())).thenReturn("1");
        //Service
        String link = "http://localhost:8080/registration/confirm?token=1";
        String test = service.buildEmail(user.getFirstName(), link);
        //validation
        Assertions.assertTrue(test.contains(user.getFirstName()) && test.contains(link));
    }

    @Test
    public void CheckIfTheTokenIsConfirmedCorrectly() {
        //setup - data
        RegistrationRequest request = new RegistrationRequest("Andres",
                "Gomez",
                "1144090825",
                "address",
                "77777",
                "cali",
                "valle del cauca",
                "colombia",
                "af.gomez@globant.com",
                "admin123");
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
        ConfirmationToken token = ConfirmationToken.builder()
                .token("1").expiresAt(LocalDateTime.now().plusMinutes(60)).user(user).build();
        //setup - expectations
        Mockito.when(confirmationTokenService.getToken("1")).thenReturn(Optional.of(token));
        Mockito.when(userService.enableUser(user.getEmail())).thenReturn(1);
        //Service
        String test = service.confirmToken("1");
        //validation
        Assertions.assertEquals("The user is now Verified", test);
    }
}