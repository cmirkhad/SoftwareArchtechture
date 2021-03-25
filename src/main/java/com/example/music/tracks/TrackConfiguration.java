package com.example.music.tracks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class TrackConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(TrackRepository trackRepository){
        return args -> {

        };
    }
}
