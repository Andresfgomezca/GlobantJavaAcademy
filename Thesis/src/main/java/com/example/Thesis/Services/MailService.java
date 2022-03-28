package com.example.Thesis.Services;

import com.example.Thesis.Dtos.MailDTO;
import com.example.Thesis.Enums.Labels;
import com.example.Thesis.Models.Mail;
import com.example.Thesis.Models.User;
import com.example.Thesis.Repositories.MailRepository;
import com.example.Thesis.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MailService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MailRepository mailRepository;

    public Optional<Mail> get(Long id) {
        return mailRepository.findById(id);
    }

    public List<Mail> list() {
        return mailRepository.findAll();
    }

    public List<Mail> findByLabel(User user, List<Labels> labels) {
        List<Mail> mails = new ArrayList<>();
        //find emails with this labels
        for (Labels l : labels) {
            List<Mail> temporal = mailRepository.findAll().stream().filter(mail -> mail.getLabel().contains(l))
                    .collect(Collectors.toList());
            mails = Stream.concat(mails.stream(), temporal.stream()).collect(Collectors.toList());
        }
        return mails;
    }

    //
    public List<Mail> userInbox(User user) {
        List<Mail> mails = mailRepository.findAll();
        for (Mail m : mails) {
            if (!m.getUsers().contains(user)) {
                mails.remove(m);
            }
        }
        return mails;
    }

    //
    public List<Mail> userSent(User user) {
        List<Mail> mails = mailRepository.findAll();
        for (Mail m : mails) {
            if (!m.getSender().equals(user)) {
                mails.remove(m);
            }
        }
        return mails;
    }

    //
    public Mail create(MailDTO mailDTO, String creator) {
        Set<User> users = new LinkedHashSet<>();
        String[] myArray = mailDTO.getPrimaryRecipient().split(",");
        List<String> myList = Arrays.asList(myArray);
        //verification that all the users exist
        for (String email : myList) {
            User userFound = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException(email));
            users.add(userFound);
        }
        User sender = userRepository.findByEmail(creator)
                .orElseThrow(() -> new UsernameNotFoundException(creator));
        return mailRepository.save(Mail.builder()
                .sender(sender)
                .primaryRecipient(mailDTO.getPrimaryRecipient())
                .carbonCopy(mailDTO.getCarbonCopy())
                .blindCarbonCopy(mailDTO.getCarbonCopy())
                .attachments(mailDTO.getAttachments())
                .body(mailDTO.getBody())
                .label(mailDTO.getLabels())
                .sentByBcc(mailDTO.getSentByBcc())
                .subject(mailDTO.getSubject())
                .users(users)
                .build());
    }


}
