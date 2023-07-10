package com.DvdSpringBootMvc.model.service;

import com.DvdSpringBootMvc.dto.entity.Dvd;
import com.DvdSpringBootMvc.model.persistence.DvdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DvdServiceImpl implements DvdService {
    @Autowired
    private DvdDao dvdDao;

    @Override
    public Dvd getDvdByTitle(String title) {
        return dvdDao.findByTitle(title);
    }

    @Override
    public List<Dvd> getAllDvds() {
        return dvdDao.findAll();
    }

    @Override
    public boolean addDvd(Dvd dvd) {
        try {
            if(dvdDao.insertDvd(dvd.getDvdId(), dvd.getTitle(), dvd.getDirectorName(), dvd.getStudio(), dvd.getUserRating()) > 0)
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteDvdByTitle(String title) {
        Dvd dvd = getDvdByTitle(title);
        if(dvd != null) {
            dvdDao.deleteByTitle(title);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserRating(String title, double newRating) {
        if(dvdDao.updateUserRatingByTitle(newRating, title) > 0)
            return true;
        else
            return false;
    }
}
