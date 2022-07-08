package com.baanBaini.BaanBaini.user.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;
    private String publicUserId;
    private Date joiningDate;
    private String name;
    private String email;
    private String encryptedPassword;

    public UserEntity() {
    }

    public UserEntity(String id, String publicUserId, Date joiningDate, String name, String email, String encryptedPassword) {
        this.id = id;
        this.publicUserId = publicUserId;
        this.joiningDate = joiningDate;
        this.name = name;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicUserId() {
        return publicUserId;
    }

    public void setPublicUserId(String publicUserId) {
        this.publicUserId = publicUserId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
