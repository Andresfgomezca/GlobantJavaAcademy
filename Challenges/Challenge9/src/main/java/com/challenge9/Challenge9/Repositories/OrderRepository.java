package com.challenge9.Challenge9.Repositories;

import com.challenge9.Challenge9.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
