package com.gymmanagement.system.repository;

import com.gymmanagement.system.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
