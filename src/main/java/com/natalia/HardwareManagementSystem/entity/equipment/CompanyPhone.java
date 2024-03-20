package com.natalia.HardwareManagementSystem.entity.equipment;

import com.natalia.HardwareManagementSystem.entity.Equipment;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_phone")
public class CompanyPhone extends Equipment {

    @Column(name = "phone_number")
    private String phoneNumber;

}
