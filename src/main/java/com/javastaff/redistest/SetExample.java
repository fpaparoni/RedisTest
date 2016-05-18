package com.javastaff.redistest;

import redis.clients.jedis.Jedis;

public class SetExample {
    public static void main(String a[]) {
        Jedis jedis = new Jedis("localhost");
        
        jedis.sadd("insieme1", "1");
        jedis.sadd("insieme1", "2");
        jedis.sadd("insieme1", "3");
        jedis.sadd("insieme1", "4");
        
        System.out.println(jedis.smembers("insieme1"));
        
        jedis.sadd("insieme2", "2");
        jedis.sadd("insieme2", "4");
        jedis.sadd("insieme2", "6");
        jedis.sadd("insieme2", "8");
        
        System.out.println(jedis.smembers("insieme2"));
        System.out.println(jedis.sunion("insieme1","insieme2"));
        System.out.println(jedis.sinter("insieme1","insieme2"));
        
        jedis.del("insieme1");
        jedis.del("insieme2");
    }
}
