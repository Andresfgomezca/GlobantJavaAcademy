package com.example.Thesis;

import com.example.Thesis.Enums.UserRol;
import com.example.Thesis.Exceptions.EmailConfirmedException;
import com.example.Thesis.Models.User;
import com.example.Thesis.Repositories.UserRepository;
import com.example.Thesis.Services.ConfirmationTokenService;
import com.example.Thesis.Services.EmailValidator;
import com.example.Thesis.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailValidatorTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private EmailValidator emailValidator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void CheckIfTheEmailValidatorValidates() {
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

        //Service
        emailValidator.test(user.getEmail());
        //validation
        Assertions.assertEquals(true, emailValidator.test(user.getEmail()));
    }
}
