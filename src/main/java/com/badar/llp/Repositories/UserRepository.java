package com.badar.llp.Repositories;

import com.badar.llp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT userName from User Where userName ")
    User findByUserName(String userName);
}
