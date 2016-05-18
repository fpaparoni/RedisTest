package com.javastaff.redistest;

import redis.clients.jedis.Jedis;

public class ExpireExample {
    public static void main(String a[]) throws InterruptedException {
        Jedis jedis = new Jedis("localhost");
        jedis.set("provaexpire", "test");
        jedis.expire("provaexpire", 10);
        Long ttl=jedis.ttl("provaexpire");
        while (ttl!=-2) {
            System.out.println("La chiave può vivere ancora per "+ttl+" secondi");
            Thread.sleep(1000);
            ttl=jedis.ttl("provaexpire");
        }
        System.out.println("La chiave non c'è più †");
    }
}
