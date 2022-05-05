package csc319.example.videospringdemo;

import csc319.example.videospringdemo.controller.Video;
import csc319.example.videospringdemo.repository.VideoModel;
import csc319.example.videospringdemo.repository.VideoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.management.MXBean;
import java.util.Collection;

@SuppressWarnings("ALL")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableWebMvc
@Configuration
public class VideoSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoSpringDemoApplication.class, args);
    }
    @Bean
    public VideoRepository videoRepository(){
        return new VideoModel();

    }
}
