package com.roboelectric.shopslisting.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.roboelectric.shopslisting.configuration.AWSConfiguration;
import com.roboelectric.shopslisting.configuration.VaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3Service {
    private final Logger LOGGER = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    AmazonS3 s3client;

    @Autowired
    VaultTemplate vaultTemplate;

    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        var putObjectResult = s3client.putObject(VaultService.AWS_BUCKET_NAME, keyName, file.getInputStream(), null);
        LOGGER.error("[HARMLESS]"+putObjectResult.getMetadata());
    }

    public S3Object getFile(String keyName) {
        S3Object s3Object = s3client.getObject(VaultService.AWS_BUCKET_NAME, keyName);
        return s3Object;
    }

}
