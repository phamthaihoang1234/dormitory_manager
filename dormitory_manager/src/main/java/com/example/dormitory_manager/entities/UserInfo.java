package com.example.dormitory_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.intellij.lang.annotations.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo extends AbstractEntity implements Serializable {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();


    @NotNull
    private String username;
    private String name;

    private String address;


    @Column(unique = true)
    private String email;


    @NotNull
    private String password;

    @NotNull
    private String gender;




    @NotNull
    private String phoneNumber;

    private Boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Transient
    private String token;


    @ManyToOne
    @JoinColumn(name = "room_id", nullable = true)
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<WebReview> comments;

    private String passwordToken;//for password recovery
    private String avatar;

    public UserInfo(String username, String name, String address, String email, String password, String gender, String phoneNumber, Boolean active, Set<Role> roles, String token, List<WebReview> comments, String passwordToken, String avatar) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.roles = roles;
        this.token = token;
        this.comments = comments;
        this.passwordToken = passwordToken;
        this.avatar = avatar;
    }

    public UserInfo() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<WebReview> getComments() {
        return comments;
    }

    public void setComments(List<WebReview> comments) {
        this.comments = comments;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public void setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
