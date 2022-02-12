package com.lyricfinder.service;


import com.lyricfinder.model.Track;
import com.lyricfinder.model.User;
import com.lyricfinder.repository.TrackRepository;
import com.lyricfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppService implements LyricService{

    @Autowired
    TrackRepository trackRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String email, String password) {
        User userFromDao= userRepository.getByemail(email);
        String decryptedPassword=decryptPassword(userFromDao.getPassword());
        if(userFromDao!=null && decryptedPassword.equalsIgnoreCase(password)){
            return userFromDao;
        }
        return null;
    }

    @Override
    public User CreateUser(String email,String password) {
        if(!email.isEmpty() && !password.isEmpty()) {
            String encyptedPassword=encryptPassword(password);
            User newUser = userRepository.save(new User(email,encyptedPassword));
            return newUser;
        }
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> getBestNtracks(int n) {
        List<Track> tracklist=trackRepository.findTopNTracks(n).
                           stream().collect(Collectors.toList());
        return tracklist;
    }


    @Override
    public Track addTrack(Track track) {
        try {
            Optional<Track> track1 = trackRepository.findById(track.getId());
            if(!track1.isPresent()){
                return trackRepository.save(track);
            }
        }catch (Exception ex){
            return null;
        }
      return null;
    }

    @Override
    public Track getTrackById(Integer id) {
        Optional<Track> track1 = trackRepository.findById(id);
        if(track1.isPresent()){
            return track1.get();
        }
        return null;
    }

    private String encryptPassword(String password){
        Base64.Encoder encoder=Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }

    private String decryptPassword(String encryptedPassword){
        Base64.Decoder decoder=Base64.getDecoder();
        byte[] bytes=decoder.decode(encryptedPassword);
        return new String(bytes);
    }


}
