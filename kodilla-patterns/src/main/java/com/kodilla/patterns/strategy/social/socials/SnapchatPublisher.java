package com.kodilla.patterns.strategy.social.socials;

public final class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        String socialName = "Snapchat";
        System.out.println(socialName);
        return socialName;
    }
}
