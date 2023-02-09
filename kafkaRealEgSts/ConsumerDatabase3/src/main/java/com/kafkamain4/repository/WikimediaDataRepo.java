package com.kafkamain4.repository;

import com.kafkamain4.entity.Wikimedia3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository<Wikimedia3, Long> {

}
