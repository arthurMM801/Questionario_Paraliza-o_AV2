package Q5_QuickSort;

import java.util.List;

public class QuickSortSerial {

    public void ordena(List<Integer> lista) {

        System.out.println("Serial");
        long start = System.currentTimeMillis();

        quickSort(lista, 0, lista.size()-1);

        long finish = System.currentTimeMillis();
        System.out.println("Tempo= "+ (finish - start)+"ms");
    }

    private static void quickSort(List<Integer> lista, int start, int finish) {
        if (start < finish) {
            int pivotIndex = partition(lista, start, finish);
            quickSort(lista, start, pivotIndex - 1);
            quickSort(lista, pivotIndex + 1, finish);
        }
    }

    public static int partition(List<Integer> lista, int start, int finish) {
        int pivot = lista.get(finish);
        int i = start-1;

        for (int j = start; j < finish; j++) {
            if (lista.get(j) < pivot) {
                i++;
                int temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        int temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(finish));
        lista.set(finish, temp);

        return i + 1;
    }
}
