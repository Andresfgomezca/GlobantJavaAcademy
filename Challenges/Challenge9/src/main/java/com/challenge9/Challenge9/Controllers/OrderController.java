package com.challenge9.Challenge9.Controllers;

import com.challenge9.Challenge9.Models.Order;
import com.challenge9.Challenge9.Repositories.OrderRepository;
import com.challenge9.Challenge9.Services.OrderService;
import com.challenge9.Challenge9.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/store/order", method = RequestMethod.POST)
    public OrderDto createOrder(@RequestBody OrderDto order) {
        return service.createOrder(order);
    }

    @RequestMapping(value = "/store/inventory", method = RequestMethod.GET)
    public Map<String, Integer> getOrdersInventory() {
        return service.getInventory();
    }

    @RequestMapping(value = "/store/orders", method = RequestMethod.GET)
    public ResponseEntity<Order> list() {
        List<Order> orders = service.list();
        return new ResponseEntity(orders, HttpStatus.OK);
    }
}
