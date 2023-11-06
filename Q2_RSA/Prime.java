package Q2_RSA;

public class Prime implements Runnable {
    public long number = 1;
    public int ordem;


    public Prime(int ordem) {
        this.ordem = ordem;
    }

//    private Boolean isPrime(long number){
//        for(long i = 2; i < number; i++){
//            if((number%i) == 0){
//                return false;
//            }
//        }
//        return true;
//    }



    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private long random() {
        return (long)(Math.random() * Math.pow(10, ordem));
    }

    @Override
    public void run() {
        long prime = random();
        while(!isPrime(prime)){
            prime = random();
        }
        this.number = prime;
        System.out.printf("Número aleatório da ordem de 10^%d: %d\n", ordem, number);
    }
}
