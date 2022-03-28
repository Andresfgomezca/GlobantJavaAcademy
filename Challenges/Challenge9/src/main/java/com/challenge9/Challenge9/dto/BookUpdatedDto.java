package com.challenge9.Challenge9.dto;

import com.challenge9.Challenge9.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdatedDto {
    private String name;
    private Status status;
}
