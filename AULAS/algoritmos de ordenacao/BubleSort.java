package AULAS;

public class BubleSort {
 
    public void bubleSort(int[] v) {

        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j < v.length - i - 1;j++){
                if(v[j] > v[j+1]){
                    swap(v,j,j+1);
                }
            }
        }
    }

    // versão otimizada
    public void bubleSortOtimizado(int[] v) {

        for(int i = 0; i < v.length; i++) {
            boolean trocou = false;
            for(int j = 0; j < v.length - i - 1;j++){
                if(v[j] > v[j+1]){
                    swap(v,j,j+1);
                    trocou = true;
                }
            }
            if (!trocou) return;
        }
    }

    public void swap(int[] v, int i, int j) {
        int aux = v[j];
        v[j] = v[j-1];
        v[j-1] = aux;
    }
}
