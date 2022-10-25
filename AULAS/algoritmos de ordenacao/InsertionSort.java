package AULAS;

public class InsertionSort {
    
    public void insertSort(int[] v){

        for(int i = 1; i < v.length; i++) {

            int j = i;

            while(j < 0 && v[j] < v[j-1]) {
                int aux = v[j];
                v[j] = v[j-1];
                v[j-1] = aux;
                j -= 1;
            }
        }
    }

}
