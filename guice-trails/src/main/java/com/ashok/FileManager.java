package com.ashok;

import javax.inject.Inject;
import javax.inject.Named;

public class FileManager {

    @Inject @Named("azure")
    private ObjectStore azureFiledObjectStore;
    @Inject @Named("amazon")
    private ObjectStore amazonFiledObjectStore;

    private ObjectStore amazonConstructorObjStore;
    private ObjectStore azureConstructorObjStore;

    @Inject
    public FileManager(@Named("amazon") ObjectStore amazonConstructorObjStore, @Named("azure") ObjectStore azureConstructorObjStore){

        this.amazonConstructorObjStore = amazonConstructorObjStore;
        this.azureConstructorObjStore = azureConstructorObjStore;
    }


    public Object downloadFromAzureFiledInjection(String fileName){
        return azureFiledObjectStore.download(fileName);
    }

    public Object downloadFromAmazonFiledInjection(String fileName){
        return amazonFiledObjectStore.download(fileName);
    }

    public Object downloadFromAzureConstructInjection(String fileName){
        return azureConstructorObjStore.download(fileName);
    }

    public Object downloadFromAmazonConstructInjection(String fileName){
        return amazonConstructorObjStore.download(fileName);
    }

}
