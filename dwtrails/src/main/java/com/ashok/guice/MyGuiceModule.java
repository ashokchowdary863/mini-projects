package com.ashok.guice;

import com.ashok.AppConfig;
import com.ashok.exception.AppExceptionMapper;
import com.ashok.exception.ConstraintViolationExceptionMapper;
import com.ashok.resources.CounterResource;
import com.ashok.resources.UserResource;
import com.google.inject.Singleton;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class MyGuiceModule extends DropwizardAwareModule<AppConfig> {


    @Override
    protected void configure() {
        bind(AppExceptionMapper.class).in(Singleton.class);
        bind(ConstraintViolationExceptionMapper.class).in(Singleton.class);
        bind(UserResource.class).in(Singleton.class);
        bind(CounterResource.class).in(Singleton.class);
    }
}
