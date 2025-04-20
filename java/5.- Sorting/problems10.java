// 912. Sort an Array
/* Instrucciones: 
Dada una matriz de números enteros, ordene la matriz en orden ascendente y devuélvala.

Debe resolver el problema sin utilizar ninguna función incorporada en O(nlog(n)) 
complejidad de tiempo y con la menor complejidad de espacio posible.
*/
public class Solution {
    public int[] sortArray(int[] nums) {
        // Función para fusionar dos subarreglos ordenados
        int[] merge(int[] left, int[] right) {
            int[] sorted = new int[left.length + right.length];
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    sorted[k++] = left[i++];
                } else {
                    sorted[k++] = right[j++];
                }
            }

            // Agregar los elementos restantes
            while (i < left.length) sorted[k++] = left[i++];
            while (j < right.length) sorted[k++] = right[j++];

            return sorted;
        }

        // Función recursiva para dividir y ordenar
        int[] mergeSort(int[] arr) {
            if (arr.length <= 1) return arr; // Caso base

            int mid = arr.length / 2;
            int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // Mitad izquierda
            int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length)); // Mitad derecha

            return merge(left, right); // Fusionar las mitades ordenadas
        }

        return mergeSort(nums);
    }
}