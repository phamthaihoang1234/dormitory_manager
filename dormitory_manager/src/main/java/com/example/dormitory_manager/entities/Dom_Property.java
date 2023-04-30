
package com.example.dormitory_manager.entities;

        import javax.persistence.*;
        import java.util.List;

@Entity
@Table(name = "dom_property")
public class Dom_Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Boolean status;

    public Dom_Property() {
    }

    public Dom_Property(String type, Boolean status) {
        this.type = type;
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "dom_property")
    private List<Dom> doms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Dom> getDoms() {
        return doms;
    }

    public void setDoms(List<Dom> doms) {
        this.doms = doms;
    }
}
