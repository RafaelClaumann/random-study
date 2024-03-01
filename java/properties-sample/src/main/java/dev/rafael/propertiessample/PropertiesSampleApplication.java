package dev.rafael.propertiessample;

import dev.rafael.propertiessample.lists.SocialMediaProperties;
import dev.rafael.propertiessample.maps.BookmarkProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({SocialMediaProperties.class, BookmarkProperties.class})
@SpringBootApplication
public class PropertiesSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesSampleApplication.class, args);
    }

}
