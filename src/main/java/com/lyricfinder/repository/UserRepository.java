package com.lyricfinder.repository;


import com.lyricfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User getByemail(String email);
    User save(User user);
    Optional<User> findByEmail(String email);
}
