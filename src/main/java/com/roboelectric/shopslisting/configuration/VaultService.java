package com.roboelectric.shopslisting.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@Component
public class VaultService {

    @Autowired
    VaultTemplate vaultTemplate;

    private static VaultTemplate vaultTemplateAPI;
    public static String AWS_ACCESS_KEY="";
    public static String AWS_SECRET_KEY="";
    public static String AWS_BUCKET_NAME="";
    public static String AWS_SQS_QUEUE_NAME="";

    @PostConstruct
    public void init() {
        vaultTemplateAPI = vaultTemplate;
        initialiseValues();
    }
    private void initialiseValues() {
        VaultResponse vaultResponse = vaultTemplateAPI.opsForKeyValue("secret", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2).get("AWS_CREDS");
        AWS_ACCESS_KEY = String.valueOf(vaultResponse.getData().get("access"));
        AWS_SECRET_KEY = String.valueOf(vaultResponse.getData().get("secret"));
        AWS_BUCKET_NAME = String.valueOf(vaultResponse.getData().get("bucket"));
        AWS_SQS_QUEUE_NAME = String.valueOf(vaultResponse.getData().get("sqsQueueName"));
    }
}
