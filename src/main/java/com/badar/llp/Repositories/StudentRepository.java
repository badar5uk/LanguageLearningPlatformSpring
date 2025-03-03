package com.badar.llp.Repositories;

import com.badar.llp.Models.Student;
import com.badar.llp.Models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM student s WHERE s.userName = :userName")
    Student findByUserName(@Param("userName") String userName);
}
