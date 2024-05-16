package com.kodilla.patterns.strategy.social;

public class User {
    private String username;
    protected SocialPublisher socialPublisher;

    public User(String username, SocialPublisher socialPublisher) {
        this.username = username;
        this.socialPublisher = socialPublisher;
    }

    public String getUsername() {
        return username;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public void sharePost() {
        socialPublisher.share();
    }
}
