package com.natalia.HardwareManagementSystem.repository;

import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyBranchRepository extends JpaRepository<CompanyBranch, Integer> {
    CompanyBranch findCompanyBranchById(int branchId);
    List<CompanyBranch> findAllByOrderByName();
}
