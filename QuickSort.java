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
}
