package com.ashok;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Redis!" );
        Jedis jedis = new Jedis(new HostAndPort("localhost", 6379));
        jedis.set("java_1", "one");
        System.out.println(jedis.get("java_1"));
    }
}
