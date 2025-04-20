// 62. Unique Paths
/* Instrucciones: 
Hay un robot en una cuadrícula m x n. El robot se encuentra inicialmente 
   en la esquina superior izquierda (es decir, la cuadrícula[0][0]). 
   El robot intenta moverse hasta la esquina inferior derecha (es decir, 
   la cuadrícula[m - 1][n - 1]). El robot sólo puede moverse hacia abajo o 
   hacia la derecha en cualquier momento.

Dados los números enteros m y n, devuelve el número de caminos posibles 
   que puede seguir el robot para llegar a la esquina inferior derecha.

Los casos de prueba se generan de forma que la respuesta sea menor o igual que 2 * 109.
*/
var uniquePaths = function(m, n) {
    const dp = Array.from({ length: m }, () => Array(n).fill(0));

    // Inicializar la primera fila y la primera columna
    for (let i = 0; i < m; i++) dp[i][0] = 1;
    for (let j = 0; j < n; j++) dp[0][j] = 1;

    // Llenar la matriz dp
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[m - 1][n - 1];
};


// 63. Unique Paths II
/* Instrucciones: 
Se le da una m x n rejilla de matriz de enteros. Hay un robot situado 
   inicialmente en la esquina superior izquierda (es decir, rejilla[0][0]). 
   El robot intenta moverse a la esquina inferior derecha (es decir, 
   rejilla[m - 1][n - 1]). El robot sólo puede moverse hacia abajo o hacia 
   la derecha en cualquier momento.

Un obstáculo y un espacio se marcan como 1 o 0 respectivamente en la cuadrícula. 
   Un camino que tome el robot no puede incluir ninguna casilla que sea un obstáculo.

Devuelve el número de caminos únicos posibles que el robot puede tomar 
  para llegar a la esquina inferior derecha.

Los casos de prueba se generan de forma que la respuesta sea menor o igual que 2 * 109.
*/
var uniquePathsWithObstacles = function(obstacleGrid) {
    const m = obstacleGrid.length;
    const n = obstacleGrid[0].length;

    // Si la celda inicial o final tiene un obstáculo, no hay caminos
    if (obstacleGrid[0][0] === 1 || obstacleGrid[m - 1][n - 1] === 1) {
        return 0;
    }

    const dp = Array.from({ length: m }, () => Array(n).fill(0));
    dp[0][0] = 1; // Punto de partida

    // Inicializar la primera columna
    for (let i = 1; i < m; i++) {
        dp[i][0] = obstacleGrid[i][0] === 0 && dp[i - 1][0] === 1 ? 1 : 0;
    }

    // Inicializar la primera fila
    for (let j = 1; j < n; j++) {
        dp[0][j] = obstacleGrid[0][j] === 0 && dp[0][j - 1] === 1 ? 1 : 0;
    }

    // Llenar la matriz dp
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (obstacleGrid[i][j] === 0) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            } else {
                dp[i][j] = 0; // Obstáculo
            }
        }
    }

    return dp[m - 1][n - 1];
};

// Ejemplo de uso:
console.log(uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]])); // Output: 2
console.log(uniquePathsWithObstacles([[0, 1], [0, 0]])); // Output: 1

// 1143. Longest Common Subsequence
/* Instrucciones: 
Dadas dos cadenas texto1 y texto2, devuelve la longitud de su subsecuencia 
   común más larga. Si no hay subsecuencia común, devuelve 0.

Una subsecuencia de una cadena es una nueva cadena generada a partir
   de la cadena original con algunos caracteres (puede ser ninguno) 
   eliminados sin cambiar el orden relativo de los caracteres restantes.

Por ejemplo, "ace" es una subsecuencia de "abcde".
Una subsecuencia común de dos cadenas es una subsecuencia que es común a ambas cadenas.
*/
var longestCommonSubsequence = function(text1, text2) {
    const m = text1.length;
    const n = text2.length;
    const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

    // Llenar la matriz dp
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (text1[i - 1] === text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[m][n];
};


