package AULAS;

import AULAS.Partition;

public class QuickSort {

    public static void quickSort(int[] values, int left, int right) {
        if (left < right) {
            int index_pivot = Partition(values, left, right);
            quickSort(v, left, index_pivot - 1);
            quickSort(v, index_pivot + 1, right);	
        }
    }
    
}
