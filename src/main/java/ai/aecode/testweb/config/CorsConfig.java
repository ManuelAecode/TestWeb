package ai.aecode.testweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","DELETE", "OPTIONS", "PATCH", "POST", "PUT")
                .allowedHeaders("x-requested-with", "authorization", "Content-Type", "Authorization", "credential", "X-XSRF-TOKEN")
                .maxAge(3600);
    }
}
