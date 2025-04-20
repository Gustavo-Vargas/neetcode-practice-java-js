// 75. Sort Colors
/* Instrucciones: 
Dada una matriz nums con n objetos de color rojo, blanco o azul, ordénelos en su lugar 
  de modo que los objetos del mismo color sean adyacentes, con los colores en el orden 
  rojo, blanco y azul.

Usaremos los enteros 0, 1 y 2 para representar el color rojo, blanco y azul, respectivamente.

Debes resolver este problema sin utilizar la función de ordenación de la biblioteca.
*/
public class Solution {
    public void sortColors(int[] nums) {
        // Paso 1: Contar los elementos
        int[] count = new int[3]; // count[0] para 0, count[1] para 1, count[2] para 2
        for (int num : nums) {
            count[num]++;
        }

        // Paso 2: Sobrescribir el arreglo original
        int index = 0;
        for (int i = 0; i < count[0]; i++) nums[index++] = 0; // Escribir todos los 0
        for (int i = 0; i < count[1]; i++) nums[index++] = 1; // Escribir todos los 1
        for (int i = 0; i < count[2]; i++) nums[index++] = 2; // Escribir todos los 2
    }

    // Ejemplo de uso:
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // Output: [0, 1, 2]
    }
}


