package com.gymmanagement.system.service;

import com.gymmanagement.system.model.Trainer;
import com.gymmanagement.system.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository repository;

    public TrainerService(TrainerRepository repository) {
        this.repository = repository;
    }

    public List<Trainer> getAllTrainers() {
        return repository.findAll();
    }

    public Trainer saveTrainer(Trainer trainer) {
        return repository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        repository.deleteById(id);
    }
}
