package com.challenge9.Challenge9.Services;

import com.challenge9.Challenge9.Models.Book;
import com.challenge9.Challenge9.Models.Order;
import com.challenge9.Challenge9.Models.Tag;
import com.challenge9.Challenge9.Repositories.BookRepository;
import com.challenge9.Challenge9.Repositories.OrderRepository;
import com.challenge9.Challenge9.dto.OrderDto;
import com.challenge9.Challenge9.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    public OrderDto createOrder(OrderDto order){
        Book book =  bookRepository.findById(order.getBookId()).get();
        Order orderToSave = new Order(order.getId(),
                book,
                order.getQuantity(),
                order.getShipDate(),
                order.getStatus(),
                order.isComplete());
        orderRepository.save(orderToSave);

        return order;
    }
    public List<Order> list() {
        return orderRepository.findAll();
    }

    public Map<String, Integer> getInventory(){
        Map<String, Integer> OrderByStatus = new HashMap<String, Integer>();
        OrderByStatus.put("placed", orderRepository.findAll().stream().filter(order -> order.getStatus().equals(OrderStatus.placed)).toList().size());
        OrderByStatus.put("delivered", orderRepository.findAll().stream().filter(order -> order.getStatus().equals(OrderStatus.delivered)).toList().size());
        OrderByStatus.put("approved", orderRepository.findAll().stream().filter(order -> order.getStatus().equals(OrderStatus.approved)).toList().size());

        return OrderByStatus;
    }
}