package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socials.SnapchatPublisher;

public class YGeneration extends User{
    public YGeneration(String userName) {
        super(userName);
        this.socialPublisher = new SnapchatPublisher();
    }
}
