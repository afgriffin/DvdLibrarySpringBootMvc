package com.DvdSpringBootMvc.dto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dvd {

    @Id
    private int dvdId;
    @Column(name = "title")
    private String title;
    private String directorName;
    private String studio;
    @Column(name = "user_rating")
    private double userRating;

}
