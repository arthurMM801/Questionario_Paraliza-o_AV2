package Q6_Verifica_n_primo;

import java.util.Collection;

class main {

    public static void main(String[] args) {
        int n = 100;
        Collection<Long> Primos = new Manager().calculaPrimos(n);
        System.out.println(Primos);
    }
}
