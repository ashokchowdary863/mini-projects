package com.ashok;

import io.dropwizard.Configuration;

public class MyAppConfig extends Configuration {
     public String applicationName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
