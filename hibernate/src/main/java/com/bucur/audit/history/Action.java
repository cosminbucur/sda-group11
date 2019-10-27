package com.bucur.audit.history;

public enum Action {

    INSERTED("INSERTED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String name;

    Action(String value) {
        this.name = value;
    }

}
