package com.gymmanagement.system.service;

import com.gymmanagement.system.model.Attendance;
import com.gymmanagement.system.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    public Attendance saveAttendance(Attendance attendance) {
        return repository.save(attendance);
    }
}
