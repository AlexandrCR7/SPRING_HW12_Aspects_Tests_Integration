package ru.gb.Spring_HW12_Tests_Aspects_Integrations.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGateWay {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
