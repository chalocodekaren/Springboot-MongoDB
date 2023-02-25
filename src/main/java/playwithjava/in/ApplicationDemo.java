package playwithjava.in;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@Slf4j
@EnableMongoRepositories
public class ApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemo.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
