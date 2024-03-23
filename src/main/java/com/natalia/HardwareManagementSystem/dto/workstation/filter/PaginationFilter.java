package com.natalia.HardwareManagementSystem.dto.workstation.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationFilter {
    private int itemsPerPage = 30;
    public int page = 0;
}
