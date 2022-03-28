package com.challenge9.Challenge9.dto;

import com.challenge9.Challenge9.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
public class OrderDto {
    @Id
    private Long id;
    private Long bookId;
    private int quantity;
    private Date shipDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private boolean complete=false;
}
