package com.challenge9.Challenge9.Models;

import com.challenge9.Challenge9.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;
    private int quantity;
    private Date shipDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private boolean complete=false;


}
