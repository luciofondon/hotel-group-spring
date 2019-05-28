package es.hotel.back.hotelgroup.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerProperties {

    private String basePackage;
    private String pathsRegex;
    private String title;
    private String description;
    private String license;
    private String version;

}
