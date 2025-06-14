package com.uthpala.unit_testing_examples.service;

import com.uthpala.unit_testing_examples.dto.UserReportDTO;

public interface ReportService {
    UserReportDTO generateUserReport(Long userId);
}
