package com.baanBaini.BaanBaini.admin.model.dto;

import com.baanBaini.BaanBaini.configuration.security.Authority;

import java.util.Date;
import java.util.List;

public class AdminDTO {
    private String publicAdminId;
    private String name;
    private String email;
    private Date joiningDate;

    private String password;

    private List<Authority> authorities;
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

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
