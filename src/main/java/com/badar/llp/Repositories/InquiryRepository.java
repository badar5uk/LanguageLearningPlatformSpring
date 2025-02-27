package com.badar.llp.Repositories;

import com.badar.llp.Models.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry,Integer> {
}
