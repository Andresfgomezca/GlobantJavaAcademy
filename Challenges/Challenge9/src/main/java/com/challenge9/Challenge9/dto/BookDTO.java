package com.challenge9.Challenge9.dto;

import com.challenge9.Challenge9.Models.Category;
import com.challenge9.Challenge9.enums.Status;
import com.challenge9.Challenge9.Models.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    Long id;
    String name;
    Status status;
    private Category category;
    private List<Tag> tags = new ArrayList<>();
}
