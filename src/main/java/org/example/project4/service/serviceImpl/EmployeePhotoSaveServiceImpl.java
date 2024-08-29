package org.example.project4.service.serviceImpl;

import org.example.project4.dto.request.EmployeePhotoSaveApiRequest;
import org.example.project4.dto.response.EmployeePhotoSaveApiResponse;

import org.example.project4.entity.EmployeeEntity;
import org.example.project4.repository.EmployeeRepository;
import org.example.project4.service.EmployeePhotoSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class EmployeePhotoSaveServiceImpl implements EmployeePhotoSaveService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${file.upload.directory}")
    private String uploadDirectory;


    @Override
    public EmployeePhotoSaveApiResponse save(EmployeePhotoSaveApiRequest request) throws IOException {
        MultipartFile empPhoto = request.getEmployeePhoto();

        String photoName =empPhoto.getOriginalFilename();
        String filePath = uploadDirectory+ File.separator + photoName;

        //save the file
        byte[] bytes= empPhoto.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path, bytes);

        System.out.println(photoName);

        EmployeeEntity entity = new EmployeeEntity();
        EmployeePhotoSaveApiResponse response =new EmployeePhotoSaveApiResponse();

        try{
            entity.setEmployeeId(request.getEmployeeId());
            entity.setFileName(photoName);

            employeeRepository.save(entity);

            response.setMessage("photo save successfully : "+photoName);
            response.setStatus("200");
            response.setCode("4000");



        }catch (Exception e){
            response.setMessage("photo save Unsuccessfully "+e.getMessage());
            response.setStatus("400");
            response.setCode("4001");

        }


        return response;
    }
}
