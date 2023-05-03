package com.example.dormitory_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends AbstractEntity implements Serializable {
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String address;
    @Column(name = "price_per_night")
    private Double pricePerNight;
    @Column(name = "total_of_bedroom")
    private int totalOfBedroom;
    @Column(name = "total_of_bathroom")
    private int totalOfBathroom;
    @Column(name = "cancelled", nullable = true)
    private Boolean cancelled = false;
    private Boolean status = true;
    public Room() {
        
    }
    public Room(String name, String description, String address, double price_per_night, int totalOfBedroom,
            int totalOfBathroom, Boolean cancelled, Boolean status) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.pricePerNight = price_per_night;
        this.totalOfBedroom = totalOfBedroom;
        this.totalOfBathroom = totalOfBathroom;
        this.cancelled = cancelled;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getTotalOfBedroom() {
        return totalOfBedroom;
    }

    public void setTotalOfBedroom(int totalOfBedroom) {
        this.totalOfBedroom = totalOfBedroom;
    }

    public int getTotalOfBathroom() {
        return totalOfBathroom;
    }

    public void setTotalOfBathroom(int totalOfBathroom) {
        this.totalOfBathroom = totalOfBathroom;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Dom getDom() {
        return dom;
    }

    public void setDom(Dom dom) {
        this.dom = dom;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Object getAvgRatting() {
        return avgRatting;
    }

    public void setAvgRatting(Object avgRatting) {
        this.avgRatting = avgRatting;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImgSrc3() {
        return imgSrc3;
    }

    public void setImgSrc3(String imgSrc3) {
        this.imgSrc3 = imgSrc3;
    }

    

//    @OneToMany(orphanRemoval = true, mappedBy = "room")
//    private List<RoomImage> roomImages;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Booking> bookings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true, updatable = false)
    private UserInfo user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dom_id", nullable = true, updatable = false)
    private Dom dom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id", nullable = true, updatable = false)
    private Discount discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_type",nullable = true, updatable = false)
    private PropertyType propertyType;

    @Transient
    private  Object avgRatting;

    @Transient
    MultipartFile image;


    @Column(nullable = true)
    private String imgSrc3;


}
