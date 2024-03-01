package dev.rafael.propertiessample.maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SocialMediaPropertiesMapTest {

    @Autowired
    private BookmarkProperties bookmarkProperties;

    @Test
    void shouldContainTwoWebsites() {
        Assertions.assertFalse(bookmarkProperties.websites().isEmpty());
        Assertions.assertEquals(2, bookmarkProperties.websites().size());

        Assertions.assertTrue(bookmarkProperties.websites().containsKey("Twitter"));
        Assertions.assertTrue(bookmarkProperties.websites().containsKey("Facebook"));
    }

    @Test
    void shouldContainTwitterWebsiteAndUrl() {
        Website twitter = bookmarkProperties.websites().get("Twitter");

        Assertions.assertNotNull(twitter);
        Assertions.assertNotNull(twitter.url());
        Assertions.assertEquals("https://twitter.com", twitter.url());
    }

    @Test
    void shouldContainFacebookWebsiteAndUrl() {
        Website twitter = bookmarkProperties.websites().get("Facebook");

        Assertions.assertNotNull(twitter);
        Assertions.assertNotNull(twitter.url());
        Assertions.assertEquals("https://facebook.com", twitter.url());
    }

}
