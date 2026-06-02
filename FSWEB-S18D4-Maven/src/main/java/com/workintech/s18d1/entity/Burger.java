package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="burger", schema="burgertab")
public class Burger {
    @Id
    private long id;
    private String name;
    private Double price;
    @Column(name="is_vegan")
    private boolean isVegan;
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    private String contents;

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public Boolean getIsVegan () {
        return  this.isVegan;
    }
}
