package com.example.Thesis.Services;

import com.example.Thesis.Exceptions.EmailNotValidException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {

        //this regexPattern will validate emails that will have an abbreviation or a short name,
        //follow with a dot and lastname with domain globant.com
        String regexPattern = "^(?=.{1,12}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "globant.com";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();

    }
}