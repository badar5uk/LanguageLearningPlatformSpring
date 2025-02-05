package com.badar.llp.Repositories;

import com.badar.llp.Models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {
}
