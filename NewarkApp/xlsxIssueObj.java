package com.example.ese343finalproject.Newark;

import com.example.ese343finalproject.Newark.xlsxManager;

public class xlsxIssueObj extends xlsxManager {
    private double latitude, longitude, racePercent;
    private double issueNumber, rating, agencyID, requestTypeID, slaHours, agentID, minutesAcknowledged, minutesToClosed;
    private String status, summary, address, description, agencyName, exportedTags, requestType;
    private String updatedAtLocal, createdAtLocal, acknowledgedAtLocal, reopenedAtLocal, closedAtLocal;
    private String assigneeName, streetAddress, category, slaExpiresAtLocal, agentName, reportMethod;
    private String reporterName, dueAtLocal, reportSoruce, reportMethodCode, tractNum;
    private boolean createdByMember;

    public double getRacePercent(){ return  racePercent; }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public double getRating() {
        return rating;
    }

    public double getAgencyID() {
        return agencyID;
    }

    public double getRequestTypeID() {
        return requestTypeID;
    }

    public double getSlaHours() {
        return slaHours;
    }

    public double getAgentID() {
        return agentID;
    }

    public double getMinutesAcknowledged() {
        return minutesAcknowledged;
    }

    public double getMinutesToClosed() {
        return minutesToClosed;
    }

    public String getStatus() {
        return status;
    }

    public String getTractNum(){
        return tractNum;
    }

    public String getSummary() {
        return summary;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getReportMethodCode() {
        return reportMethodCode;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getExportedTags() {
        return exportedTags;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getUpdatedAtLocal() {
        return updatedAtLocal;
    }

    public String getCreatedAtLocal() {
        return createdAtLocal;
    }

    public String getAcknowledgedAtLocal() {
        return acknowledgedAtLocal;
    }

    public String getReopenedAtLocal() {
        return reopenedAtLocal;
    }

    public String getClosedAtLocal() {
        return closedAtLocal;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCategory() {
        return category;
    }

    public String getSlaExpiresAtLocal() {
        return slaExpiresAtLocal;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getReportMethod() {
        return reportMethod;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getDueAtLocal() {
        return dueAtLocal;
    }

    public String getReportSoruce() {
        return reportSoruce;
    }

    public boolean getCreatedByMember() {
        return createdByMember;
    }

    public void setRacePercent(double racePercent) { this.racePercent = racePercent;}

    public xlsxIssueObj(double issueNumber, String status, String summary, double rating, String address, String description,
                        String agencyName, double agencyID, double requestTypeID, double latitude, double longitude,
                        String exportedTags, String requestType, String updatedAtLocal, String createdAtLocal,
                        String acknowledgedAtLocal, String reopenedAtLocal, String closedAtLocal, double minutesAcknowledged,
                        double minutesToClosed, String assigneeName, String streetAddress, String category, double slaHours, String slaExpiresAtLocal,
                        String agentName, double agentID, String reportMethodCode, String reportMethod, String reporterName, String dueAtLocal,
                        String reportSoruce, boolean createdByMember, String tractNum){
        this.issueNumber = issueNumber;
        this.status = status;
        this.summary = summary;
        this.rating = rating;
        this.address = address;
        this.description = description;
        this.agencyName = agencyName;
        this.agencyID = agencyID;
        this.requestTypeID = requestTypeID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.exportedTags = exportedTags;
        this.requestType = requestType;
        this.updatedAtLocal = updatedAtLocal;
        this.createdAtLocal = createdAtLocal;
        this.acknowledgedAtLocal = acknowledgedAtLocal;
        this.reopenedAtLocal = reopenedAtLocal;
        this.closedAtLocal = closedAtLocal;
        this.minutesAcknowledged = minutesAcknowledged;
        this.minutesToClosed = minutesToClosed;
        this.assigneeName = assigneeName;
        this.streetAddress = streetAddress;
        this.category = category;
        this.slaHours = slaHours;
        this.slaExpiresAtLocal = slaExpiresAtLocal;
        this.agentName = agentName;
        this.agentID = agentID;
        this.reportMethodCode = reportMethodCode;
        this.reportMethod = reportMethod;
        this.reporterName = reporterName;
        this.dueAtLocal = dueAtLocal;
        this.reportSoruce = reportSoruce;
        this.createdByMember = createdByMember;
        this.tractNum = tractNum;
    }

}
