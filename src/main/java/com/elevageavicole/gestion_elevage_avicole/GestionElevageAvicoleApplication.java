package com.elevageavicole.gestion_elevage_avicole;

import com.elevageavicole.gestion_elevage_avicole.repository.AlimentRepository;
import com.elevageavicole.gestion_elevage_avicole.repository.LotPouletRepository;
import com.elevageavicole.gestion_elevage_avicole.repository.VenteRepository;
import com.elevageavicole.gestion_elevage_avicole.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionElevageAvicoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionElevageAvicoleApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner demoData(
            LotPouletRepository lotPouletRepository,
            AlimentRepository alimentRepository,
            VenteRepository venteRepository,
            UserRepository userRepository) {
        return (args) -> {

        };
    }
}