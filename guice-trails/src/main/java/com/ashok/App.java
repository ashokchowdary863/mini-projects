package com.ashok;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Injector injector = Guice.createInjector(new MyGuiceModule());
        FileManager fileManager = injector.getInstance(FileManager.class);
        System.out.println( fileManager.downloadFromAmazonConstructInjection("Dummy.txt"));
        System.out.println( fileManager.downloadFromAzureConstructInjection("Dummy.txt"));
        System.out.println( fileManager.downloadFromAmazonFiledInjection("Dummy.txt"));
        System.out.println( fileManager.downloadFromAzureFiledInjection("Dummy.txt"));

    }
}
