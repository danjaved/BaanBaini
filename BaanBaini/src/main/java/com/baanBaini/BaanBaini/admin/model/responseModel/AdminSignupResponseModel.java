package com.baanBaini.BaanBaini.admin.model.responseModel;

public class AdminSignupResponseModel {
    private String publicAdminId;
    private String name;
    private String email;
    private String joiningDate;
    private String phoneNumber;
    public String getPublicAdminId() {
        return publicAdminId;
    }

    public void setPublicAdminId(String publicAdminId) {
        this.publicAdminId = publicAdminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
