package org.example.project4.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmployeePhotoSaveApiRequest {
    private String employeeId;
    private MultipartFile employeePhoto;
}
