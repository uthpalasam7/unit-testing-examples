package com.uthpala.unit_testing_examples.dto;

import lombok.Data;

@Data
public class UserReportDTO {
    private String userName;
    private int totalOrders;
    private boolean hasPremiumAccount;
}
