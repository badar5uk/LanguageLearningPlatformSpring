package com.badar.llp.Repositories;

import com.badar.llp.Models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Integer> {
}
