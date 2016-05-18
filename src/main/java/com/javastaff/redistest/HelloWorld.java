package com.javastaff.redistest;

import redis.clients.jedis.Jedis;

public class HelloWorld {
    public static void main(String a[]) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("hello", "world");
        String value = jedis.get("hello");
        System.out.println(value);
    }
}
