// 191. Number of 1 Bits
/* Instrucciones: 
Dado un número entero positivo n, escriba una función que devuelva 
  el número de bits de conjunto en su representación binaria 
(también conocido como peso Hamming).
*/
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) { // Un entero tiene 32 bits
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1; // Desplazar la máscara hacia la izquierda
        }

        return count;
    }
}

// 338. Counting Bits
/* Instrucciones: 
Dado un número entero n, devuelve una matriz ans de longitud n + 1 
   tal que para cada i (0 <= i <= n), ans[i] es el número de 1's en 
   la representación binaria de i.
*/
public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1); // i >> 1 es i / 2, i & 1 verifica si el bit menos significativo es 1
        }

        return ans;
    }
}



// 192. Reverse Bits
/* Instrucciones: 
Invierte los bits de un entero sin signo de 32 bits dado.

Nota:
 - Tenga en cuenta que en algunos lenguajes, como Java, no existe el tipo 
    entero sin signo. En este caso, tanto la entrada como la salida se darán 
    como un tipo entero con signo. Esto no debería afectar a tu implementación, 
    ya que la representación binaria interna del entero es la misma, tenga o no signo.

 - En Java, el compilador representa los enteros con signo utilizando la 
    notación de complemento a 2. Por lo tanto, en el ejemplo 2 anterior, 
    la entrada representa el entero con signo -3 y la salida representa el
     entero con signo -1073741825.
*/
public class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1; // Desplazar result hacia la izquierda
            result |= (n & 1); // Agregar el bit menos significativo de n a result
            n >>= 1; // Desplazar n hacia la derecha
        }

        return result;
    }
}


