package com.ashok.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Counter {
    @JsonProperty
    private String applicationName;
    @JsonProperty
    private int count;

    public Counter(String applicationName, int count) {
        this.applicationName = applicationName;
        this.count = count;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
