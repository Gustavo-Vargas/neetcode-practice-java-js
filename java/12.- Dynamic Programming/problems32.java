// 70. Climbing Stairs
/* Instrucciones: 
Estás subiendo una escalera. Se necesitan n escalones para llegar arriba.

Cada vez puedes subir 1 o 2 escalones. ¿De cuántas formas distintas 
puedes subir hasta arriba?
*/
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}


// 198. House Robber
/* Instrucciones: 
Eres un ladrón profesional que planea robar casas a lo largo de una calle. 
   Cada casa tiene una cierta cantidad de dinero escondido, la única 
   restricción que te impide robar en cada una de ellas es que las casas 
   adyacentes tienen sistemas de seguridad conectados y se pondrá 
   automáticamente en contacto con la policía si dos casas adyacentes 
   fueron asaltadas en la misma noche.

Dada una matriz de enteros nums que representa la cantidad de dinero de  
   cada casa, devuelve la cantidad máxima de dinero que puedes robar esta 
   noche sin alertar a la policía.
*/
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}

