package com.tkluza.smartcity.smartmobility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SmartMobilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartMobilityApplication.class, args);
    }
}