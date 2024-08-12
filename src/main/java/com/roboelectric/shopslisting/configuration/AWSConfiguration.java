package com.roboelectric.shopslisting.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@Configuration
public class AWSConfiguration {

    @Bean
    public AmazonS3 s3client() {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(VaultService.AWS_ACCESS_KEY, VaultService.AWS_SECRET_KEY);
        var awsS3Config = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.AP_SOUTH_1) // This field if not exist throws an exception
                .build();

        return awsS3Config;
    }
}
