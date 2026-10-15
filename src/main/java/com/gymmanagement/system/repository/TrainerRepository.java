package com.gymmanagement.system.repository;

import com.gymmanagement.system.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
