package Q5_QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100000;
        QuickSortSerial serial = new QuickSortSerial();
        QuickSortParalelo paralelo = new QuickSortParalelo();

        List<Integer> lista = generateRandomList(size);
        serial.ordena(lista);

        lista = generateRandomList(size);
        paralelo.ordena(lista);
    }

    public static List<Integer> generateRandomList(int n) {

        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(n);
            randomList.add(randomNumber);
        }

        return randomList;
    }
}
