package Q5_QuickSort;

import java.util.List;

public class QuickSortParalelo {
    public static void ordena(List<Integer> list) {
        System.out.println("Paralelo");
        long start = System.currentTimeMillis();

        QuickSortManeger(list, 0, list.size() - 1);

        long finish = System.currentTimeMillis();
        System.out.println("Tempo= "+ (finish - start)+"ms");
    }

    public static void QuickSortManeger(List<Integer> list, int start, int finish) {
        if (start < finish) {
            int pivo = Partition(list, start, finish);

            Thread leftThread = new Thread(new QuickSortRunnable(list, start, pivo - 1));
            Thread rightThread = new Thread(new QuickSortRunnable(list, pivo + 1, finish));

            leftThread.start();
            rightThread.start();

            try {
                leftThread.join();
                rightThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int Partition(List<Integer> list, int start, int finish) {
        int pivot = list.get(finish);
        int i = start - 1;

        for (int j = start; j < finish; j++) {
            if (list.get(j) < pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        int temp = list.get(i + 1);
        list.set(i + 1, list.get(finish));
        list.set(finish, temp);

        return i + 1;
    }
    private static class QuickSortRunnable implements Runnable {
        private List<Integer> list;
        private int start, finish;

        public QuickSortRunnable(List<Integer> list, int start, int finish) {
            this.list = list;
            this.start = start;
            this.finish = finish;
        }

        @Override
        public void run() {
            QuickSortManeger(list, start, finish);
        }
    }
}
