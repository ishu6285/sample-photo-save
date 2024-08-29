package org.example.project4.controller;

import org.example.project4.dto.request.EmployeePhotoSaveApiRequest;
import org.example.project4.dto.response.EmployeePhotoSaveApiResponse;
import org.example.project4.service.EmployeePhotoSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeePhotoSaveController {
    @Autowired
    private EmployeePhotoSaveService employeePhotoSaveService;

    @PostMapping("/save")
    public EmployeePhotoSaveApiResponse photoSave(@ModelAttribute EmployeePhotoSaveApiRequest request) throws IOException {

        return employeePhotoSaveService.save(request);
    }



}
