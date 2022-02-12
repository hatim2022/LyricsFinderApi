package com.lyricfinder.controller;


import com.lyricfinder.dto.Trackdto;
import com.lyricfinder.model.Track;
import com.lyricfinder.service.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController extends BaseController {

    @Autowired
    LyricService service;

    @GetMapping("/track/{trackId}")
    public ResponseEntity<Track> getTrackById(@PathVariable Integer trackId){
        Track track=service.getTrackById(trackId);
        if(track!=null){
            return ResponseEntity.ok(track);
        }
        return new ResponseEntity("Track not found", HttpStatus.NOT_FOUND);
    }

   @PostMapping("/tracks/add")
   public ResponseEntity<Track> createTrack(@RequestBody Track track){
       Track newTrack = service.addTrack(track);
       if(newTrack==null){
          return new ResponseEntity("track already exist",HttpStatus.NOT_FOUND);
       }
       return ResponseEntity.ok(newTrack);
   }

   @GetMapping("/tracks")
   public ResponseEntity<List<Track>> getAllTracks(){
        List<Track> tracks=service.getAllTracks();
        if(tracks.isEmpty()){
            return new ResponseEntity("no track found",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tracks);
   }

   @GetMapping("/tracks/{n}")
   public ResponseEntity<List<Track>> getBestNTracks(@PathVariable int n){
       List<Track> tracks=service.getBestNtracks(n);
       if(tracks.isEmpty()){
           return new ResponseEntity("no track found",HttpStatus.NOT_FOUND);
       }
       return ResponseEntity.ok(tracks);
   }

    @PostMapping("/tracks")
    public ResponseEntity<Track> getTrackByName(@RequestBody Trackdto track){
        Track track1=service.getTrackByName(track.getName());
        if(track1==null){
            return new ResponseEntity("no track found",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(track1);
    }

}
