package com.workintech.fswebs18challengemaven.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="card",schema = "burgercasino")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="value")
    private Integer value;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Color color;


    public Card(Long id, Integer value, Color color) {
        if (value != null && value <= 0) {
            throw new IllegalArgumentException("Kart değeri 0 veya negatif bir sayı olamaz!");
        }
        this.id = id;
        this.value = value;
        this.color = color;
        this.type = null;
    }

    public Card(Long id, Type type, Color color) {
        if (type == Type.JOKER && color != null) {
            throw new IllegalArgumentException("JOKER kartının color değeri null olmalıdır!");
        }
        this.id = id;
        this.type = type;
        this.color = color;
        this.value = null;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", value=" + value +
                ", type=" + type +
                ", color=" + color +
                '}';
    }
}
