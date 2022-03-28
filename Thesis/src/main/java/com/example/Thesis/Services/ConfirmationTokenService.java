package com.example.Thesis.Services;

import com.example.Thesis.Models.ConfirmationToken;
import com.example.Thesis.Repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    // public Optional<ConfirmationToken> getTokenById(Long id) {
    //    return confirmationTokenRepository.findById(id);
//}
    public int setConfirmedAt(String token, LocalDateTime parse) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

    public String doSomething() {
        return UUID.randomUUID().toString();
    }
}
