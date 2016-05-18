package com.javastaff.redistest;

import redis.clients.jedis.Jedis;

public class RedisQueue {
    
    private String QUEUE="provacoda";
    private final Jedis jedis;
    
    public RedisQueue() {
        this.jedis = new Jedis("localhost");
    }
    
    public RedisQueue(String queue,String host) {
        this.QUEUE=queue;
        this.jedis = new Jedis(host);
    }
    
    public RedisQueue(String queue) {
        this.QUEUE=queue;
        this.jedis = new Jedis("localhost");
    }
    
    public static void main(String a[]) {
        RedisQueue queue=new RedisQueue();
        queue.inserisci("Mario Rossi");
        queue.inserisci("Giuseppe Verdi");
        queue.inserisci("Antonio Bianchi");
        String elemento=queue.rimuovi();
        while(elemento!=null) {
            System.out.println("Serviamo il signor: "+elemento);
            elemento=queue.rimuovi();
        }
        queue.distruggi();
    }
    
    public void inserisci(String valore) {
        jedis.lpush(QUEUE, valore);
    }
    
    public String rimuovi() {
        return jedis.rpop(QUEUE);
    }
    
    public String attendi() {
        return jedis.blpop(0,QUEUE).get(1);
    }
    
    public void distruggi() {
        jedis.del(QUEUE);
    }
    
}
