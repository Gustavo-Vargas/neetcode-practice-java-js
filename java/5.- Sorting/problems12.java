// 912. Sort an Array con Quick Sort
/* Instrucciones: 
Dada una matriz de números enteros, ordene la matriz en orden ascendente y devuélvala.

Debe resolver el problema sin utilizar ninguna función incorporada en O(nlog(n)) 
complejidad de tiempo y con la menor complejidad de espacio posible.
*/
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Función para intercambiar dos elementos en el arreglo
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Función para particionar el arreglo
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Elegir el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Intercambiar elementos
            }
        }
        swap(arr, i + 1, high); // Colocar el pivote en su posición correcta
        return i + 1; // Retornar el índice del pivote
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Índice del pivote
            quickSort(arr, low, pi - 1); // Ordenar la subpartición izquierda
            quickSort(arr, pi + 1, high); // Ordenar la subpartición derecha
        }
    }

}

// 215. Kth Largest Element in an Array
/* Instrucciones: 
Dado un array entero nums y un entero k, devuelve el k-ésimo elemento más grande del array.

Nótese que es el k-ésimo elemento mayor en el orden, no el k-ésimo elemento distinto.

*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1); // k-1 porque los índices son 0-based
    }

    // Función para intercambiar dos elementos en el arreglo
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Función para particionar el arreglo
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Elegir el último elemento como pivote
        int i = left; // Índice para colocar elementos mayores al pivote

        for (int j = left; j < right; j++) {
            if (arr[j] > pivot) { // Orden descendente
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right); // Colocar el pivote en su posición correcta
        return i; // Retornar el índice del pivote
    }

    // Quick Select para encontrar el k-ésimo elemento más grande
    private int quickSelect(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivotIndex = partition(arr, left, right);

            if (pivotIndex == k) {
                return arr[pivotIndex]; // Encontramos el k-ésimo elemento más grande
            } else if (pivotIndex < k) {
                return quickSelect(arr, pivotIndex + 1, right, k); // Buscar en la derecha
            } else {
                return quickSelect(arr, left, pivotIndex - 1, k); // Buscar en la izquierda
            }
        }
        return -1;
    }
}

