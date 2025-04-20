// 509. Fibonacci Number
/* Instrucciones:
Los números de Fibonacci, comúnmente denotados F(n) forman una secuencia, llamada sucesión de Fibonacci, tal que cada número es la suma de los dos anteriores, empezando por 0 y 1. Es decir,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), para n > 1.
Dado n, calcula F(n).
*/
public class Solution {
    public int fib(int n) {
        if (n == 0) return 0; // Caso base
        if (n == 1) return 1; // Caso base
        return fib(n - 1) + fib(n - 2); // Llamadas recursivas
    }
}


// 70. Climbing Stairs
/* Instrucciones: 
  Estás subiendo una escalera. Se necesitan n escalones para llegar arriba.

  Cada vez puedes subir 1 o 2 escalones. ¿De cuántas formas distintas puedes 
  subir hasta arriba?  
*/
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1; // Caso base
        if (n == 2) return 2; // Caso base
        return climbStairs(n - 1) + climbStairs(n - 2); // Llamadas recursivas
    }
}