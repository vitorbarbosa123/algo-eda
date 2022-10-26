import java.util.Arrays;

public class CountSort {
    
    
    public static int[] sort(int[] arr) {

        // 1º cria array com tamanho de arr - 1;
        int[] aux = new int[arr.length - 1];

        // 2º mapeia os valores de arr em aux:
        for (int i = 0; i < arr.length; i++) {
            aux[arr[i] - 1] += 1;
        } // retorno: [2,3,2,1,0,0,1,0,1]

        // 3º realiza a acumulativa dentro de aux: pos + (pos + 1)
        for (int j = 1; j < aux.length; j++) {
            aux[j] = aux[j] + aux[j-1];
        } // retorno: [2,5,7,8,8,8,9,9,10]

        // 4º cria novo array com tamanho de arr;
        int[] ord = new int[arr.length];

        // o elemento de arr será usado para buscar uma pos em C - 1 e colocado em 
        // B - 1
        for(int k = arr.length - 1; k >= 0; k--){
            ord[aux[arr[k] - 1] - 1] = arr[k];
            aux[arr[k] - 1] -= 1;
        } // retorno: [1,1,2,2,2,3,3,4,7,9]

        return ord;
    }

    public static void main(String args[]) {
        int[] arr = new int[]{3,9,1,2,2,3,7,4,1,2};
        
        System.out.println(Arrays.toString(sort(arr)));
    }

}
