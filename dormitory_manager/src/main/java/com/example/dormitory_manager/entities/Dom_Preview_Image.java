package com.example.dormitory_manager.entities;
import javax.persistence.*;

@Entity
@Table(name = "hotel_preview_image")
public class Dom_Preview_Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String image;

    public Dom_Preview_Image() {
    }

    public Dom_Preview_Image(String image, Dom dom) {
        this.image = image;
        this.dom = dom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Dom getDom() {
        return dom;
    }

    public void setDom(Dom dom) {
        this.dom = dom;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dom_id")
    private Dom dom ;

}
