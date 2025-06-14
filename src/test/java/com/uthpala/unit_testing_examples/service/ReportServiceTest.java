package com.uthpala.unit_testing_examples.service;

import com.uthpala.unit_testing_examples.dto.UserReportDTO;
import com.uthpala.unit_testing_examples.exception.UserNotFoundException;
import com.uthpala.unit_testing_examples.model.Order;
import com.uthpala.unit_testing_examples.model.User;
import com.uthpala.unit_testing_examples.service.impl.ReportServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private ReportServiceImpl reportService;

    @Test
    void testGenerateUserReport_HappyPath() {
        User user = new User(1L, "Alice", true);
        when(userService.getUserById(1L)).thenReturn(user);

        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(orderService.getOrdersForUser(1L)).thenReturn(orders);

        UserReportDTO report = reportService.generateUserReport(1L);

        assertEquals("Alice", report.getUserName());
        assertEquals(2, report.getTotalOrders());
        assertTrue(report.isHasPremiumAccount());
    }

    @Test
    void testGenerateUserReport_NoOrders() {
        User user = new User(2L, "Bob", false);
        when(userService.getUserById(2L)).thenReturn(user);

        when(orderService.getOrdersForUser(2L)).thenReturn(Collections.emptyList());

        UserReportDTO report = reportService.generateUserReport(2L);

        assertEquals("Bob", report.getUserName());
        assertEquals(0, report.getTotalOrders());
        assertFalse(report.isHasPremiumAccount());
    }

    @Test
    void testGenerateUserReport_UserIsNull() {
        when(userService.getUserById(anyLong()))
                .thenReturn(null);  // returns null → triggers "if (user == null)"

        assertThrows(UserNotFoundException.class, () -> {
            reportService.generateUserReport(99L);
        });
    }

}
