package AULAS;

public class SelectionSort {
    
    public void Selectsort(int[] v){

        for (int i = 0; i < v.length; i++) {
            // encontra o índice do menor elemento
            int indice_menor = 0;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[indice_menor])
                    indice_menor = j;
            }

            // coloca o menor na primeira posição
            int aux = v[0];
            v[0] = v[indice_menor];
            v[indice_menor] = aux;

        }   
    }
}
