package com.lyricfinder.controller;



import com.lyricfinder.model.User;
import com.lyricfinder.service.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController {

    @Autowired
    private LyricService service;

    @PostMapping("/users")
    public ResponseEntity<User> getUser(@RequestBody User user){
        User user1=service.getUser(user.getEmail(),user.getPassword());
        if(user1!=null){
            user1.setPassword("HIDDEN");
            return ResponseEntity.ok(user1);
        }
        return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users/create")
    public ResponseEntity<User> createTrack(@RequestBody User user){
        User user1 = service.CreateUser(user.getEmail(), user.getPassword());
        if(user1==null){
            return new ResponseEntity("User already exist",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }
}
