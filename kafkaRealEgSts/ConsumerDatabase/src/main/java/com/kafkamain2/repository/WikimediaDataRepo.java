package com.kafkamain2.repository;

import com.kafkamain2.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository<Wikimedia, Long> {

}
