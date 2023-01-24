package ua.hillelit.lms.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link AppConfig} is a class for configuration app.
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@Configuration
public class AppConfig {

    /**
     * Convert entity object to dto
     *
     * @return new objectMapper
     */
    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
