package com.firebaseapp.clovis_saintiano.employeetimetracker.model;

public class Company_Details {

    String companyId;
    String companyName;
    String companyDepartmentt;
    String companyAssignment;
    String companyYear;
    String userDate;
    String userDay;
    String userMonth;
    String rejected;
    String approved;

    public Company_Details() {

    }

    public Company_Details(String companyId, String companyName, String companyDepartmentt, String companyAssignment, String companyYear, String userDate, String userDay, String userMonth, String rejected, String approved) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDepartmentt = companyDepartmentt;
        this.companyAssignment = companyAssignment;
        this.companyYear = companyYear;
        this.userDate = userDate;
        this.userDay = userDay;
        this.userMonth = userMonth;
        this.rejected = rejected;
        this.approved = approved;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDepartmentt() {
        return companyDepartmentt;
    }

    public void setCompanyDepartmentt(String companyDepartmentt) {
        this.companyDepartmentt = companyDepartmentt;
    }

    public String getCompanyAssignment() {
        return companyAssignment;
    }

    public void setCompanyAssignment(String companyAssignment) {
        this.companyAssignment = companyAssignment;
    }

    public String getCompanyYear() {
        return companyYear;
    }

    public void setCompanyYear(String companyYear) {
        this.companyYear = companyYear;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserDay() {
        return userDay;
    }

    public void setUserDay(String userDay) {
        this.userDay = userDay;
    }

    public String getUserMonth() {
        return userMonth;
    }

    public void setUserMonth(String userMonth) {
        this.userMonth = userMonth;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }
}
