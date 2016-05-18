package com.javastaff.redistest;

public class QueueProducer {
    public static void main(String a[]) {
        RedisQueue queue=new RedisQueue("CODA_CASELLO");
        queue.inserisci("CHIUDI CASELLO");
    }
}
