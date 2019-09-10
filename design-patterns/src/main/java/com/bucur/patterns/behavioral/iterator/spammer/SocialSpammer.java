package com.bucur.patterns.behavioral.iterator.spammer;

import com.bucur.patterns.behavioral.iterator.iterators.ProfileIterator;
import com.bucur.patterns.behavioral.iterator.social_networks.SocialNetwork;

public class SocialSpammer {

    public SocialNetwork network;
    public ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    // TODO: implement this
    public void sendSpamToFriends(String profileEmail, String message) {

    }

    // TODO: implement this
    public void sendSpamToCoworkers(String profileEmail, String message) {

    }

    public void sendMessage(String email, String message) {
        System.out.println("Sent message to: '" + email + "'. Message body: '" + message + "'");
    }
}
