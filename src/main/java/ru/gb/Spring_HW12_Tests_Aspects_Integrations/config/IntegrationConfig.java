package ru.gb.Spring_HW12_Tests_Aspects_Integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.util.Locale;

@Configuration
public class IntegrationConfig {
    @Bean
    public MessageChannel textInputChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> myTransFormer(){
        return text -> text.toLowerCase().trim();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler myMessageHandler(){
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("C:\\Deals\\WorkBook\\java\\SpringTasks\\Spring_HW12_Tests_Aspects_Integrations"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}
