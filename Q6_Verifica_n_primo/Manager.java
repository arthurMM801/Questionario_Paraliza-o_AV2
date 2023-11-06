package Q6_Verifica_n_primo;

import java.util.ArrayList;
import java.util.Collection;

public class Manager {
    public Collection<Long> calculaPrimos(int n){
        long tempoInicial = System.currentTimeMillis();
        long tempoFinal;

        int nunProcessadores = 4;
        System.out.println(nunProcessadores + " Processadores");

        int valorInical = 1;
        int valorFinal = n;

        // Lista de threads
        Collection<CalculaPrimo> threads = new ArrayList<>();

        Collection<Long> primos = new ArrayList<>();

        int trabalho = valorFinal / valorInical;
        for(int i = 1; i <= nunProcessadores; i++){
            int trabalhoArredondado = Math.round(trabalho/nunProcessadores);

            int fim = trabalhoArredondado * i;
            int ini = (fim - trabalhoArredondado) + 1;

            CalculaPrimo thread = new CalculaPrimo(ini, fim, primos);
            System.out.println(ini + " - " + fim);
            thread.setName("Thread " + i);
            threads.add(thread);
        }

        for(CalculaPrimo calculaPrimo: threads){
            calculaPrimo.start();
        }

        for(CalculaPrimo calculaPrimo: threads){
            try {
                calculaPrimo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Nº de primos = " + primos.size());


        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = " + (tempoFinal - tempoInicial));

        return primos;
    }
}
