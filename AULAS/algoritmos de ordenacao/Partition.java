package AULAS;

import java.util.Arrays;

public class Partition {

    public static int partition(int[] values, int left, int right){

        // melhorias: alteração do pivot por um valor aleatório no array
        int range = right - left + 1;
        int rand_pivot_index = (int)(Math.random() * range) + left;

        // troca do valor aleatório com a primeira opção
        swap(values, left, rand_pivot_index);

        int pivot = values[left];
        int i = left;

        for(int j = left + 1; j <= right; j++) { // right = values.length - 1
            if(values[j] <= pivot) {
                i+= 1;
                swap(values,i,j);
            }
        }
        // troca o pivot (values[left]) com i
        swap(values,left, i);

    return i;
    }

    // alternativa para escolha de pivot: mediana
    public int pickPivotIndex(int[] values, int left, int right){
        int mid = (left + right) / 2;

        int[] sorted = {values[left], values[mid], values[right]};
        Arrays.sort(sorted);

        if(sorted[1] == values[left]) return left;
        else if (sorted[1] == values[mid]) return mid;
        else return right;
    }
    

    // alternativa para partition: a estabilidade é mantida(eu acho)
    public int EstablePartition(int[]v, int left, int right){
        left = 0;
        right = v.length - 1;
        int mid = (left + right) / 2;
        int pivot = v[left];

        for (int j = pivot + 1; j < right; j++){
            if(pivot < j){
                v[j] = v[pivot];
                j++;
            }
            else if(pivot == j) {
                j++;
            }
        }
        swap(v, left, right);
    }
}
