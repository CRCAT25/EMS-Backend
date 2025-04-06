package net.thanhdevjava.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.thanhdevjava.ems_backend.dto.EmployeeDTO;
import net.thanhdevjava.ems_backend.entity.Employee;
import net.thanhdevjava.ems_backend.exception.ResourceNotFoundException;
import net.thanhdevjava.ems_backend.mapper.EmployeeMapper;
import net.thanhdevjava.ems_backend.repository.EmployeeRepository;
import net.thanhdevjava.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOS = employees
                .stream()
                .map(EmployeeMapper::mapToEmployeeDTO)
                .toList();

        return employeeDTOS;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {

        Long id = employeeDTO.getId();
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {

        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employeeRepository.delete(employee);
    }
}
