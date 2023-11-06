package Q6_Verifica_n_primo;

import java.util.ArrayList;
import java.util.Collection;

public class CalculaPrimo extends Thread{
    int valorInicial;
    int valorFinal;
    Collection<Long> primos = new ArrayList<>();

    public CalculaPrimo(int valorInicial, int valorFinal, Collection<Long> primos) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.primos = primos;
    }


    @Override
    public void run(){
        for(long i=valorInicial; i <= valorFinal;i++){
            System.out.println(i);
            int primo = 0;

            for(long j = 2; j < i; j++){
                if(i % j == 0){
                    primo++;
                    break;
                }
            }

            if(primo == 0 || i == 2) {
                synchronized (primos) {
                    primos.add(i);
                }
            }
        }
    }
}
