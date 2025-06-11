package com.emergency_system.emergency_system.models.dtos.Request;

public class ReportRequestDTO {
    private final String incidentId;
    private final String reportDescription;

    public ReportRequestDTO(String incidentId, String reportDescription) {
        this.incidentId = incidentId;
        this.reportDescription = reportDescription;
    }


    public String getReportDescription() {
        return reportDescription;
    }
}
