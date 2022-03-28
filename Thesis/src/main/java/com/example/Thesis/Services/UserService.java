package com.example.Thesis.Services;

import com.example.Thesis.Enums.UserRol;
import com.example.Thesis.Exceptions.EmailConfirmedException;
import com.example.Thesis.Exceptions.UserNotFoundException;
import com.example.Thesis.Models.ConfirmationToken;
import com.example.Thesis.Models.User;
import com.example.Thesis.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    //UserDetailsService implements the security methods of the module security to find the users once they are logged in


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
    //this method will load the user from the repository and if the user does not exist it will provide an exception
    {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(email));
    }

    public String signUpUser(User User) {
        //verification if the user exists
        boolean userExists = userRepository
                .findByEmail(User.getEmail())
                .isPresent();

        if (userExists && !userRepository.findByEmail(User.getEmail()).get().getEnabled()) {
            // this method verifies if  the user exist
            throw new EmailConfirmedException(User.getEmail());
        }

        //method implemented to encrypt the password
        String encodedPassword = bCryptPasswordEncoder
                .encode(User.getPassword());

        User.setPassword(encodedPassword);
        //user is being saved in the db
        userRepository.save(User);
        //creation of the token for the user
        String token = confirmationTokenService.doSomething();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                User
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;
    }


    public void createAdminprofiles() {
        CharSequence charSequence = "admin123";
        String password = bCryptPasswordEncoder.encode(charSequence);
        userRepository.save(User.builder()
                .email("af.gomez@globant.com")
                .firstName("Andres")
                .lastName("Gomez")
                .password(password)
                .userRol(UserRol.ADMIN)
                .locked(false)
                .enabled(true)
                .build());
        userRepository.save(User.builder()
                .email("andres.rey@globant.com")
                .firstName("Andres")
                .lastName("Rey")
                .password(password)
                .userRol(UserRol.ADMIN)
                .locked(false)
                .enabled(true)
                .build());
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

}