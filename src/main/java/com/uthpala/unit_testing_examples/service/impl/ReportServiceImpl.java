package com.uthpala.unit_testing_examples.service.impl;

import com.uthpala.unit_testing_examples.dto.UserReportDTO;
import com.uthpala.unit_testing_examples.exception.UserNotFoundException;
import com.uthpala.unit_testing_examples.model.Order;
import com.uthpala.unit_testing_examples.model.User;
import com.uthpala.unit_testing_examples.service.OrderService;
import com.uthpala.unit_testing_examples.service.ReportService;
import com.uthpala.unit_testing_examples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final UserService userService;
    private final OrderService orderService;

    public ReportServiceImpl(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public UserReportDTO generateUserReport(Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        List<Order> orders = orderService.getOrdersForUser(userId);

        UserReportDTO report = new UserReportDTO();
        report.setUserName(user.getName());
        report.setTotalOrders(orders.size());
        report.setHasPremiumAccount(user.isPremium());

        return report;
    }
}
