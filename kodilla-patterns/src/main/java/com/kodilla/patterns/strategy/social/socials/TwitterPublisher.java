package com.kodilla.patterns.strategy.social.socials;

public final class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        String socialName = "Twitter";
        System.out.println(socialName);
        return socialName;
    }
}
