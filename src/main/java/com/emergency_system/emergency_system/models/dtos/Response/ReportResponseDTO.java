package com.emergency_system.emergency_system.models.dtos.Response;

public class ReportResponseDTO {
    public class ReportResponseDTO {

        private String reportId;
        private String reportDescription;
    
        public String getReportId() {
            return reportId;
        }
    
        public void setReportId(String reportId) {
            this.reportId = reportId;
        }
    
        public String getReportDescription() {
            return reportDescription;
        }
    
        public void setReportDescription(String reportDescription) {
            this.reportDescription = reportDescription;
        }
    
        
    }
}
