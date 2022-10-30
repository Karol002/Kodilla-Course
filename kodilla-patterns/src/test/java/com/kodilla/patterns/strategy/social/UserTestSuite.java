package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socials.FacebookPublisher;
import com.kodilla.patterns.strategy.social.socials.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.socials.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        Millenials millenials = new Millenials("Karol");
        ZGeneration zGeneration = new ZGeneration("Michał");
        YGeneration yGeneration = new YGeneration("Kasia");

        //When && Then
        assertEquals("Facebook", millenials.sharePost());
        assertEquals("Twitter", zGeneration.sharePost());
        assertEquals("Snapchat", yGeneration.sharePost());
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        Millenials millenials = new Millenials("Karol");
        ZGeneration zGeneration = new ZGeneration("Michał");
        YGeneration yGeneration = new YGeneration("Kasia");

        //When
        millenials.setUserFavoriteSocial(new TwitterPublisher());
        zGeneration.setUserFavoriteSocial(new SnapchatPublisher());
        yGeneration.setUserFavoriteSocial(new FacebookPublisher());

        //Then
        assertEquals("Twitter", millenials.sharePost());
        assertEquals("Snapchat", zGeneration.sharePost());
        assertEquals("Facebook", yGeneration.sharePost());
    }
}
