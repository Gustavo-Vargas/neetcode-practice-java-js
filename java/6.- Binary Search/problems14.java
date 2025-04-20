// 704. Binary Search
/* Instrucciones: 
Dada una matriz de números enteros ordenados de forma ascendente y un objetivo entero, 
  escriba una función que busque el objetivo en números enteros. Si el objetivo existe, 
  devuelve su índice. En caso contrario, devuelve -1.

Usted debe escribir un algoritmo con O(log n) tiempo de ejecución complexit
*/

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calcular el índice medio

            if (nums[mid] == target) {
                return mid; // Encontramos el objetivo
            } else if (nums[mid] < target) {
                left = mid + 1; // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        }

        return -1; // El objetivo no está en el arreglo
    }
}

// 74. Search a 2D Matrix
/* Instrucciones: 
Se le da una matriz m x n entera con las dos propiedades siguientes:

Cada fila está ordenada en orden no decreciente.
El primer entero de cada fila es mayor que el último entero de la fila anterior.
Dado un objetivo entero, devolver true si el objetivo está en la matriz o false en caso contrario.

Debe escribir una solución en O(log(m * n)) complejidad de tiempo.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n; // Convertir índice lineal a fila
            int col = mid % n; // Convertir índice lineal a columna

            if (matrix[row][col] == target) {
                return true; // Encontramos el objetivo
            } else if (matrix[row][col] < target) {
                left = mid + 1; // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        }

        return false; // El objetivo no está en la matriz
    }
}


