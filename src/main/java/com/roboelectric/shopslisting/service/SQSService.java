package com.roboelectric.shopslisting.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roboelectric.shopslisting.configuration.VaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@EnableScheduling
public class SQSService {

    private final Logger LOGGER = LoggerFactory.getLogger(SQSService.class);

    @Autowired
    AmazonSQS amazonSQSClient;

    @Autowired
    ObjectMapper objectMapper;

    public void publishMessage(String id) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(VaultService.AWS_SQS_QUEUE_NAME);
            var message = com.roboelectric.shopslisting.dto.Message.builder()
                    .id(id)
                    .content("message")
                    .createdAt(new Date()).build();
            var result = amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), objectMapper.writeValueAsString(message));
        } catch (Exception e) {
            LOGGER.error("Queue Exception Message: {}", e.getMessage());
        }

    }

   // @Scheduled(fixedDelay = 5000) // It runs every 5 seconds.
    public void consumeMessages() {
        try {
            LOGGER.error("Scheduler Called: ");
            String queueUrl = amazonSQSClient.getQueueUrl(VaultService.AWS_SQS_QUEUE_NAME).getQueueUrl();

            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

            if (!receiveMessageResult.getMessages().isEmpty()) {
                com.amazonaws.services.sqs.model.Message message = receiveMessageResult.getMessages().get(0);
                LOGGER.error("[HARMLESS]Read Message from queue: {}", message.getBody());
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
            }

        } catch (Exception e) {
            LOGGER.error("Queue Exception Message: {}", e.getMessage());
        }
    }
}
