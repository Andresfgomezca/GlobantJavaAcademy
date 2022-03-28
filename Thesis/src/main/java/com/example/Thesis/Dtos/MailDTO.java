package com.example.Thesis.Dtos;

import com.example.Thesis.Enums.Labels;
import com.example.Thesis.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class MailDTO {
    private String primaryRecipient;
    private String carbonCopy;
    private String blindCarbonCopy;
    private String subject;
    private String body;
    private String attachments;
    private Boolean sentByBcc;
    private List<Labels> labels = new ArrayList<Labels>();
}
