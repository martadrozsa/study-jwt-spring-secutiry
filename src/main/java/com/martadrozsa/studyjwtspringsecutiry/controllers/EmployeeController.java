package com.martadrozsa.studyjwtspringsecutiry.controllers;

import com.martadrozsa.studyjwtspringsecutiry.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        List<EmployeeDTO> employeeDTOList = List.of(
                new EmployeeDTO(null, "Kyle"),
                new EmployeeDTO(null, "Stan"),
                new EmployeeDTO(null, "Eric"),
                new EmployeeDTO(null, "Kenny")
        );
        return ResponseEntity.ok(employeeDTOList);
    }

}
