package com.example.Thesis;

import antlr.Token;
import com.example.Thesis.Enums.UserRol;
import com.example.Thesis.Models.ConfirmationToken;
import com.example.Thesis.Models.User;
import com.example.Thesis.Repositories.ConfirmationTokenRepository;
import com.example.Thesis.Services.ConfirmationTokenService;
import com.example.Thesis.Services.EmailValidator;
import com.example.Thesis.Services.UserService;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

public class ConfirmationTokenTest {
    @Mock
    private ConfirmationTokenRepository confirmationTokenRepository;

    @InjectMocks
    private ConfirmationTokenService confirmationTokenService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void CheckIfTokensAreSaved() {
        //setup - data
        ConfirmationToken token = ConfirmationToken.builder()
                .token("token")
                .build();
        //setup - expectations
        Mockito.when(confirmationTokenRepository.findByToken(token.getToken())).thenReturn(Optional.of(token));
        //Service
        confirmationTokenRepository.save(token);
        //validation
        Assertions.assertEquals(token, confirmationTokenRepository.findByToken("token").get().getToken());
    }

    @Test
    public void CheckIfTokensAreReturnCorrectly() {
        //setup - data
        ConfirmationToken token = ConfirmationToken.builder()
                .token("token")
                .id(1L)
                .build();
        //setup - expectations
        Mockito.when(confirmationTokenRepository.findById(1L)).thenReturn(Optional.of(token));
        //Service
        confirmationTokenService.saveConfirmationToken(token);
        //validation
        Assertions.assertEquals(token.getToken(), confirmationTokenRepository.findById(token.getId()).get().getToken());
    }


    @Test
    public void CheckIfTokensAreUpdateCorrectlyWithTheCurrentTime() {
        //setup - data
        LocalDateTime datetime1 = LocalDateTime.now();
        ConfirmationToken token = ConfirmationToken.builder()
                .token("token")
                .id(1L)
                .confirmedAt(datetime1)
                .build();

        //setup - expectations
        Mockito.when(confirmationTokenRepository.findById(1L)).thenReturn(Optional.of(token));
        //Service
        confirmationTokenService.setConfirmedAt(token.getToken(), LocalDateTime.now());
        confirmationTokenRepository.save(token);
        //validation
        Assertions.assertEquals(datetime1, confirmationTokenRepository.findById(1L).get().getConfirmedAt());
    }
}
