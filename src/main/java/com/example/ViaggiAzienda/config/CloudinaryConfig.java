package com.example.ViaggiAzienda.config;
import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary uploader() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dvdgcoowu");
        config.put("api_key", "424117384547511");
        config.put("api_secret", "BBC0msurzGesaV_TaHc_5-bhxrU");
        return new Cloudinary(config);
    }
}

