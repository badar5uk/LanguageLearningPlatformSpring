package com.badar.llp.Repositories;

import com.badar.llp.Models.Tutor;
import com.badar.llp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Integer> {

    @Query("SELECT t FROM Tutor t WHERE t.user.userName = :userName")
    Tutor findByUserName(@Param("userName") String userName);
}
