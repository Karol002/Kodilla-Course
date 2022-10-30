package com.kodilla.patterns.strategy.social.socials;

public final class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        String socialName = "Facebook";
        System.out.println(socialName);
        return socialName;
    }
}
