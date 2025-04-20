// 70. Climbing Stairs
/* Instrucciones: 
Estás subiendo una escalera. Se necesitan n escalones para llegar arriba.

Cada vez puedes subir 1 o 2 escalones. ¿De cuántas formas distintas 
puedes subir hasta arriba?
*/
var climbStairs = function(n) {
    if (n === 1) return 1;

    const dp = new Array(n + 1).fill(0);
    dp[1] = 1;
    dp[2] = 2;

    for (let i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
};

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
var rob = function(nums) {
    const n = nums.length;
    if (n === 1) return nums[0];

    const dp = new Array(n).fill(0);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (let i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }

    return dp[n - 1];
};


