package net.thanhdevjava.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.thanhdevjava.ems_backend.dto.EmployeeDTO;
import net.thanhdevjava.ems_backend.entity.Employee;
import net.thanhdevjava.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO),HttpStatus.CREATED);
    }

    // Get employee by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    // Get all employees REST API
    @GetMapping("/GetAllEmployees")
    public ResponseEntity<Iterable<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    // Update Employee REST API
    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDTO),HttpStatus.OK);
    }

    // Delete employee REST API
    @DeleteMapping("/DeleteEmployee")
    public ResponseEntity<String> deleteEmployeeById(@RequestBody Map<String, Long> request) {
        employeeService.deleteEmployeeById(request.get("id"));
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }
}
