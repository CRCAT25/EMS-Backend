package net.thanhdevjava.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.thanhdevjava.ems_backend.dto.EmployeeDTO;
import net.thanhdevjava.ems_backend.entity.Employee;
import net.thanhdevjava.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Add employee REST API
    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO),HttpStatus.CREATED);
    }

    // Get employee by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    // Get all employees REST API
    @GetMapping
    public ResponseEntity<Iterable<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    // Update Employee REST API
    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDTO),HttpStatus.OK);
    }

    // Delete employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }
}
