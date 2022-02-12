package com.lyricfinder.service;

import com.lyricfinder.model.Track;
import com.lyricfinder.model.User;

;import java.util.List;

public interface LyricService {
    User getUser(String email,String password);
    User CreateUser(String email, String password);
    List<Track> getAllTracks();
    List<Track> getBestNtracks(int n);
    Track getTrackByName(String name);
    Track addTrack(Track track);
    Track getTrackById(Integer id);

}
