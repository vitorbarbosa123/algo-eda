package AULAS;
import AULAS.Merge;

public class MergeSort {
    
    public void mergeSort(int[]v, int left, int right) {
        if(left >= right) {
            return;
        }
        else {
            int middle = (left + right) / 2;
            mergeSort(v, left, middle);
            mergeSort(v, middle + 1, right);

            Merge(v, left, middle, right);
        }
    }
}
