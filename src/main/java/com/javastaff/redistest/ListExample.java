package com.javastaff.redistest;

import redis.clients.jedis.Jedis;

public class ListExample {
    public static void main(String a[]) {
        Jedis jedis = new Jedis("localhost");
        jedis.rpush("hadoop_tools", "Pig");
        jedis.rpush("hadoop_tools", "Sqoop");
        jedis.rpush("hadoop_tools", "Hive");
        jedis.rpush("hadoop_tools", "Oozie");
        jedis.rpush("hadoop_tools", "Zookeeper");

        long lunghezza = jedis.llen("hadoop_tools");
        System.out.println("Numero elementi presenti: "+lunghezza);
        System.out.println("Elementi: ");
        
        for (int i=0;i<lunghezza ;i++ ) {
            String value = jedis.lindex("hadoop_tools",i);
            System.out.println("\t"+value);
        }
        jedis.del("hadoop_tools");
    }
}
