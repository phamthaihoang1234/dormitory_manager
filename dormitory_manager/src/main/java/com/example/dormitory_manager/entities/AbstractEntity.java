package com.example.dormitory_manager.entities;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
