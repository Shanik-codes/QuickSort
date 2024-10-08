package QuickSort;

public class QuickSort {
    public static void quickSort(int[] array, int lo, int hi) {
        if (lo >= hi || lo < 0) {
            return;
        }
        int p = partition(array, lo, hi);
        quickSort(array, lo, p - 1);
        quickSort(array, p + 1, hi);
    }
    private static int partition(int[] array, int lo, int hi) {
        int pivot = array[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if(array[j] <= pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, hi);
        return i;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int size = 1000000;
        int[] array = new int[size];
        Random random = new random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        int[] arrayCopy = array.clone();

        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Quicksort runtime: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        java.util.Arrays.sort(arrayCopy);
        end = System.currentTimeMillis();
        System.out.println("Built-in sort runtime: " + (end - start) + " ms");
    }
}
