package com.argento.argento;

import com.argento.argento.project.entity.Member;
import com.argento.argento.project.entity.Project;
import com.argento.argento.project.repository.ProjectRepository;
import com.argento.argento.project.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ArgentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArgentoApplication.class, args);
    }
}
