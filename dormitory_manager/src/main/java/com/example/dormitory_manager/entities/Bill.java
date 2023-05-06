package com.example.dormitory_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false,updatable = true)
    private UserInfor userInfo;

    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private List<Payment> payments;

    public Bill() {
    }

    public Bill(Long id, UserInfor userInfo, List<Payment> payments) {
        this.id = id;
        this.userInfo = userInfo;
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfor getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfor userInfo) {
        this.userInfo = userInfo;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
