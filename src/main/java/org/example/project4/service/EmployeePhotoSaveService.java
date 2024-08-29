package org.example.project4.service;

import org.example.project4.dto.request.EmployeePhotoSaveApiRequest;
import org.example.project4.dto.response.EmployeePhotoSaveApiResponse;

import java.io.IOException;

public interface EmployeePhotoSaveService {
    EmployeePhotoSaveApiResponse save(EmployeePhotoSaveApiRequest request) throws IOException;
}
