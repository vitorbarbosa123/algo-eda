package AULAS;

public class Merge {
    
    public void merge(int[] v, int left, int middle, int right) {

        // novo array ordenado de mesmo tamanho do V
        int[] z  = new int[v.length];

        // variáveis iniciadoras
        // int ini = 0;
        // int fim = v.length - 1;
        // int meio = (ini + fim) / 2;

        int i = left;
        int j = middle + 1;
        int k = right;

        while(i <= middle && j <= right) {
            if(v[i] <= v[j]){
                z[k] = v[i];
                k++;
                i++;
            }
            else {
                z[k] = v[j];
                j++;
                k++;
            }
        }
        while(i <= middle){
            z[k] = v[i];
            k++;
            i++;
        }

        while(j <= right){
            z[k] = v[j];
            k++;
            j++;
        }
    }
}
