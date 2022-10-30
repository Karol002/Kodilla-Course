package com.kodilla.patterns.strategy.social.socials;

public sealed interface SocialPublisher
        permits FacebookPublisher, SnapchatPublisher, TwitterPublisher {
    String share();
}
