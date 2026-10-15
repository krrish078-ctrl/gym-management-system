package com.gymmanagement.system.repository;

import com.gymmanagement.system.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
