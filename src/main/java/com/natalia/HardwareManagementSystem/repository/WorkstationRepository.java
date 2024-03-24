package com.natalia.HardwareManagementSystem.repository;

import com.natalia.HardwareManagementSystem.entity.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
    Workstation findWorkstationById(int id);
    /*List<Workstation> findAllByCompanyBranch_Id(int companyBranchId, Pageable pageable);
    List<Workstation> findAllByCompanyBranch_IdAndDepartment_Id(int companyBranchId, int departmentId, Pageable pageable);*/
    List<Workstation> findAllByCompanyBranch_Id(int companyBranchId);
    List<Workstation> findAllByCompanyBranch_IdAndDepartment_IdOrderByName(int companyBranchId, int departmentId);
}
