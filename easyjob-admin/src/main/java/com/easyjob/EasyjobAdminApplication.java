package com.easyjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.easyjob"})
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class EasyjobAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyjobAdminApplication.class,args);
    }
}
