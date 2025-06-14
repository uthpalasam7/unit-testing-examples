package com.uthpala.unit_testing_examples.service.impl;

import com.uthpala.unit_testing_examples.model.Order;
import com.uthpala.unit_testing_examples.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getOrdersForUser(Long userId) {
        // Example dummy implementation → would normally call a repository or API
        return Collections.emptyList();
    }
}
