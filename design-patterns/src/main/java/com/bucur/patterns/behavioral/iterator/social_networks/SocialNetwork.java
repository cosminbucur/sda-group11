package com.bucur.patterns.behavioral.iterator.social_networks;

import com.bucur.patterns.behavioral.iterator.iterators.ProfileIterator;

public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
