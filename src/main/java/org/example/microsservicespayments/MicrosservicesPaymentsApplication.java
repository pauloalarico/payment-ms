package org.example.microsservicespayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class MicrosservicesPaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosservicesPaymentsApplication.class, args);
    }

}
