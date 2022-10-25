package com.sodse.admin_monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminMonitorApplication.class, args);
    }

}
