package com.javastaff.redistest;

public class QueueConsumer {
    public static void main(String a[]) { 
        RedisQueue queue=new RedisQueue("CODA_CASELLO");
        String targa;
        while(true){
          System.out.println("In attesa che passi una macchina...");
          targa = queue.attendi();
          if (targa != null && targa.equals("CHIUDI CASELLO")) {
              System.out.println("Chiudo il casello. Ciao ciao.");
              System.exit(0);
          } else
            System.out.println("Passata una macchina con targa " + targa);
        }
    }
}
