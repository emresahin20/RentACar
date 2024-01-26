package com.example.kamp2ders5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "cars")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "plate" ,unique = true)
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "state")
    private int state; //1 -Available 2-Rented 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
