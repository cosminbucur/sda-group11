package com.bucur.patterns.behavioral.iterator.iterators;

import com.bucur.patterns.behavioral.iterator.profile.Profile;

public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
