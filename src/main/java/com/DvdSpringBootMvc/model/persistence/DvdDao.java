package com.DvdSpringBootMvc.model.persistence;

import com.DvdSpringBootMvc.dto.entity.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface DvdDao extends JpaRepository<Dvd, Integer> {
    @Query("select d from Dvd d where d.title = ?1")
    Dvd findByTitle(String title);

    @Modifying
    @Query("delete from Dvd d where d.title = ?1")
    int deleteByTitle(String title);

    @Modifying
    @Query("update Dvd d set d.userRating = ?1 where d.title = ?2")
    int updateUserRatingByTitle(double userRating, String title);

    @Modifying
    @Query(value = "insert into dvd (dvdId, title, directorName, studio, user_rating) values (?, ?, ?, ?, ?)", nativeQuery = true)
    int insertDvd(int id, String title, String directorName, String studio, double userRating);
}
