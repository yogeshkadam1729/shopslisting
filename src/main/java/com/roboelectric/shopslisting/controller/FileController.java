package com.roboelectric.shopslisting.controller;

import com.amazonaws.services.s3.model.S3Object;
import com.roboelectric.shopslisting.service.S3Service;
import com.roboelectric.shopslisting.service.SQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
@CrossOrigin
public class FileController {
    @Autowired
    S3Service s3Service;

    @Autowired
    SQSService sqsService;

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file) throws IOException {
        s3Service.uploadFile(file.getOriginalFilename(), file);
        return new ResponseEntity<>("File Created", HttpStatus.CREATED);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(s3Service.getFile(fileName).getObjectContent()));
    }

    @GetMapping("/view/{fileName}")
    public ResponseEntity<InputStreamResource> viewFile(@PathVariable String fileName) {
        var s3Object = s3Service.getFile(fileName);
        var content = s3Object.getObjectContent();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG) // This content type can change by your file :)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+fileName+"\"")
                .body(new InputStreamResource(content));
    }

    @GetMapping("/publishSQSMessage/{id}")
    public ResponseEntity<String> publishSQSMessage(@PathVariable String id) {

        sqsService.publishMessage(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
