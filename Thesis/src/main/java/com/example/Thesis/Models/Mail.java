package com.example.Thesis.Models;

import com.example.Thesis.Enums.Labels;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "mails")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User sender;
    //String of users separated by comma
    private String primaryRecipient;
    private String carbonCopy;
    private String blindCarbonCopy;
    private boolean sentByBcc;
    private String subject;
    private String body;
    private String attachments;


    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Labels> label = new ArrayList<>(7);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mail_users",
            joinColumns = @JoinColumn(name = "mail_null"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users = new LinkedHashSet<>();


    public Mail(User sender,
                String primaryRecipient,
                String carbonCopy,
                String blindCarbonCopy,
                String subject,
                String body,
                String attachments,
                boolean sentByBcc,
                List<Labels> label) {

        this.sender = sender;
        this.primaryRecipient = primaryRecipient;
        this.carbonCopy = carbonCopy;
        this.blindCarbonCopy = blindCarbonCopy;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
        this.sentByBcc = sentByBcc;
        this.label = label;
    }

    public Mail(Mail subject) {
    }
}