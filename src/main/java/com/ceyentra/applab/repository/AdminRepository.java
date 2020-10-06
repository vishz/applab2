package com.ceyentra.applab.repository;

import org.springframework.stereotype.Repository;
import com.ceyentra.applab.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);


}