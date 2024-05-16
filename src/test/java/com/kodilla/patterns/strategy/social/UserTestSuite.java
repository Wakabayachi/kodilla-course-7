package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        SocialPublisher facebookPublisher = new FacebookPublisher();
        SocialPublisher snapchatPublisher = new SnapchatPublisher();

        User millenial = new Millenials("Millenial");
        User yGeneration = new YGeneration("YGen");

        millenial.sharePost();
        yGeneration.sharePost();

        assertTrue(true); // Placeholder for actual assertions
    }

    @Test
    void testIndividualSharingStrategy() {
        SocialPublisher facebookPublisher = new FacebookPublisher();
        SocialPublisher snapchatPublisher = new SnapchatPublisher();

        User millenial = new Millenials("Millenial");
        millenial.setSocialPublisher(snapchatPublisher);

        millenial.sharePost();

        assertTrue(true); // Placeholder for actual assertions
    }
}