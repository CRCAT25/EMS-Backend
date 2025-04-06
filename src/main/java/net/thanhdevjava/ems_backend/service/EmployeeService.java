package net.thanhdevjava.ems_backend.service;

import net.thanhdevjava.ems_backend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployeeById(Long id);
}
