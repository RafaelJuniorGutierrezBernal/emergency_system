package com.emergency_system.emergency_system.models.dtos.Request;

public class ReportRequestDTO {
    private final String reportDescription;

    public ReportRequestDTO(String reportDescription) {
        
        this.reportDescription = reportDescription;
    }


    public String getReportDescription() {
        return reportDescription;
    }
}
