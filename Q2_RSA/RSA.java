package Q2_RSA;

public class RSA extends Thread{
    public long criptografa(int ordem){
        Prime p1 = new Prime(ordem);
        Prime p2 = new Prime(ordem);

        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(p1);
        Thread thread2 = new Thread(p2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            System.out.println("Erro " + e);
        }
        long finish = System.currentTimeMillis();

        System.out.println("\nTempo= " + (finish - start));
        return p1.number * p2.number;
    }
}
