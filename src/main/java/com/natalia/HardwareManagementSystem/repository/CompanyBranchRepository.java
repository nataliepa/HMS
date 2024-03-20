package com.natalia.HardwareManagementSystem.repository;

import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBranchRepository extends JpaRepository<CompanyBranch, Integer> {
}
