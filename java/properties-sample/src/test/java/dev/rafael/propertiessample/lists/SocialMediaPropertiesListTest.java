package dev.rafael.propertiessample.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SocialMediaPropertiesListTest {

    @Autowired
    private SocialMediaProperties socialMediaProperties;

    @Test
    void shouldListAllSocialMedia() {
        Assertions.assertEquals(2, socialMediaProperties.accounts().size());
    }

    @Test
    void shouldGetTwitterAccount() {
        SocialMediaAccount twitterAccount = socialMediaProperties.accounts().get(0);

        Assertions.assertEquals("Twitter", twitterAccount.name());
        Assertions.assertEquals("Rafael", twitterAccount.username());
        Assertions.assertEquals("https://twitter.com", twitterAccount.url());
    }

    @Test
    void shouldGetFacebookAccount() {
        SocialMediaAccount facebookAccount = socialMediaProperties.accounts().get(1);

        Assertions.assertEquals("Facebook", facebookAccount.name());
        Assertions.assertEquals("Rafael", facebookAccount.username());
        Assertions.assertEquals("https://facebook.com", facebookAccount.url());
    }

}
