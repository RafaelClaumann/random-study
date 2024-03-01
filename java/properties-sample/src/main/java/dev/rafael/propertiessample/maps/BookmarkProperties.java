package dev.rafael.propertiessample.maps;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "bookmarks")
public record BookmarkProperties(Map<String, Website> websites) {
}
