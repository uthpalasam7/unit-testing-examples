package com.uthpala.unit_testing_examples.service;

import com.uthpala.unit_testing_examples.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersForUser(Long userId);
}
