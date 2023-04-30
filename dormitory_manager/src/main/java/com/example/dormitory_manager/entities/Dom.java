package com.example.dormitory_manager.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "dom")
public class Dom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status = true;
    private String nameOfDom;
    private String addressOfDom;
    private String iframe;




    public String getAddressOfDom() {
        return addressOfDom;
    }

    public void setAddressOfDom(String addressOfDom) {
        this.addressOfDom = addressOfDom;
    }

    public String getIframe() {
        return iframe;
    }



    private int hotel_standard;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dom_property_id")
    private Dom_Property dom_property;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dom")
    private List<Dom_Preview_Image> images;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "dom")
    private List<Room> rooms;


    public Dom() {
    }

    public Dom(Long id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNameOfDom() {
        return nameOfDom;
    }

    public void setNameOfDom(String nameOfHotel) {
        this.nameOfDom = nameOfHotel;
    }

    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    public int getHotel_standard() {
        return hotel_standard;
    }

    public void setHotel_standard(int hotel_standard) {
        this.hotel_standard = hotel_standard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Dom_Property getDom_property() {
        return dom_property;
    }

    public void setDom_property(Dom_Property dom_property) {
        this.dom_property = dom_property;
    }

    public List<Dom_Preview_Image> getImages() {
        return images;
    }

    public void setImages(List<Dom_Preview_Image> images) {
        this.images = images;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
