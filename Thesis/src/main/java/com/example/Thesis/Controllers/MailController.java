package com.example.Thesis.Controllers;

import com.example.Thesis.Dtos.MailDTO;
import com.example.Thesis.Enums.Labels;
import com.example.Thesis.Enums.UserRol;
import com.example.Thesis.Exceptions.UnauthorizedRequestException;
import com.example.Thesis.Models.Mail;
import com.example.Thesis.Repositories.UserRepository;
import com.example.Thesis.Services.MailService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "email")
@AllArgsConstructor
public class MailController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserRepository userRepository;

    //inbox
    @RequestMapping(value = "/inbox/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mail> inbox(@PathVariable(value = "id") Long id) {
        List<Mail> inbox = mailService.userInbox(userRepository.findById(id).get());
        return new ResponseEntity(inbox, HttpStatus.OK);
    }

    //sent
    @RequestMapping(value = "/sents/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mail> sents(@PathVariable(value = "id") Long id) {
        List<Mail> sent = mailService.userSent(userRepository.findById(id).get());
        return new ResponseEntity(sent, HttpStatus.OK);
    }

    //findbylabel
    @RequestMapping(value = "/find_by_labels/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mail> findByLabel(@PathVariable(value = "id") Long id, @RequestBody List<Labels> labels) {
        List<Mail> emailsByLabel = mailService.findByLabel(userRepository.findById(id).get(), labels);
        return new ResponseEntity(emailsByLabel, HttpStatus.OK);
    }

    //Create An Email
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public ResponseEntity<Mail> create(@PathVariable(value = "id") Long id, @RequestBody MailDTO mailDTO) {
        Mail mailCreated = mailService.create(mailDTO, userRepository.findById(id).get().getEmail());
        return new ResponseEntity(mailCreated, HttpStatus.OK);
    }

    //List of emails - only admins
    @RequestMapping(value = "/allemails/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mail> allemails(@PathVariable(value = "id") Long id) {
        if (userRepository.findById(id).get().getUserRol().equals(UserRol.ADMIN)) {
            List<Mail> allEmails = mailService.list();
            return new ResponseEntity(allEmails, HttpStatus.OK);
        } else {
            throw new UnauthorizedRequestException();

        }
    }

    //find email in db - only admins
    @RequestMapping(value = "/findemail/{id}/{emailId}", method = RequestMethod.GET)
    public ResponseEntity<Mail> findemail(@PathVariable(value = "id") Long id,
                                          @PathVariable(value = "emailId") Long emailId) {
        if (userRepository.findById(id).get().getUserRol().equals(UserRol.ADMIN)) {
            return new ResponseEntity(mailService.get(emailId), HttpStatus.OK);
        } else {
            throw new UnauthorizedRequestException();

        }
    }
}