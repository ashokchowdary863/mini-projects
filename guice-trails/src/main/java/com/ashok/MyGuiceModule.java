package com.ashok;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class MyGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ObjectStore.class).annotatedWith(Names.named("amazon")).to(AmazonS3ObjectStoreImpl.class).in(Singleton.class);
        bind(ObjectStore.class).annotatedWith(Names.named("azure")).to(AzureBlobObjectStoreImpl.class).in(Singleton.class);


    }
}
