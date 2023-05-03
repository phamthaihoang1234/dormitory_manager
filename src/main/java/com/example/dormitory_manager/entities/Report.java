package com.example.dormitory_manager.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;



@Entity
@Table(name = "report")
public class Report {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    private String name;


    @NotNull
    private String email;


    @NotNull
    private String phoneNumber;


    @NotNull
    private String message;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Dom dom;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Report(){

    }

    public Report(Long id, String name, String email, String phoneNumber, String message, Dom dom, Room room) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.dom = dom;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Dom getDom() {
        return dom;
    }

    public void setDom(Dom dom) {
        this.dom = dom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
