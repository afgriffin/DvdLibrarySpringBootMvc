package com.DvdSpringBootMvc.model.service;

import com.DvdSpringBootMvc.dto.entity.Dvd;

import java.util.List;

public interface DvdService {

    Dvd getDvdByTitle(String title);
    List<Dvd> getAllDvds();
    boolean addDvd(Dvd dvd);
    boolean deleteDvdByTitle(String title);
    boolean updateUserRating(String title, double newRating);
}
