package com.lyricfinder.repository;


import com.lyricfinder.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
    List<Track> findAll();
    Track save(Track track);
    Track getOne(Integer id);
    Optional<Track> findById(Integer id);
    @Query(value = "select * from track order by rate desc limit ?1",nativeQuery = true)
    Collection<Track> findTopNTracks(Integer n);
}
