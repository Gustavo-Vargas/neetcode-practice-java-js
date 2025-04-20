// 200. Number of Islands
/* Instrucciones: 
Dada una m x n cuadrícula binaria 2D que representa un mapa de '1's (tierra) 
  y '0's (agua), devuelva el número de islas.

Una isla está rodeada de agua y se forma conectando tierras adyacentes 
  horizontal o verticalmente. Puede suponer que los cuatro bordes de la 
  cuadrícula están rodeados de agua.
*/
var numIslands = function(grid) {
    if (!grid || grid.length === 0) return 0;

    let numIslands = 0;
    const rows = grid.length;
    const cols = grid[0].length;

    const dfs = (i, j) => {
        // Verificar límites y si la celda es agua
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] === '0') {
            return;
        }

        grid[i][j] = '0'; // Marcar la celda como visitada

        // Explorar las 4 direcciones
        dfs(i + 1, j); // Abajo
        dfs(i - 1, j); // Arriba
        dfs(i, j + 1); // Derecha
        dfs(i, j - 1); // Izquierda
    };

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (grid[i][j] === '1') {
                numIslands++;
                dfs(i, j); // Realizar DFS para marcar la isla
            }
        }
    }

    return numIslands;
};



// 695. Max Area of Island
/* Instrucciones: 
Se le da una rejilla de matriz binaria de m x n. Una isla es un grupo de 1 
   (que representa tierra) conectado en 4 direcciones (horizontal o vertical). 
   Una isla es un grupo de 1 (que representan tierra) conectadas en 4 direcciones 
   (horizontal o vertical.) Puede suponer que los cuatro bordes de la cuadrícula 
   están rodeados de agua.

El área de una isla es el número de celdas con valor 1 en la isla.

Devuelve el área máxima de una isla en la cuadrícula. Si no hay isla, devuelve 0.
*/
var maxAreaOfIsland = function(grid) {
    if (!grid || grid.length === 0) return 0;

    const rows = grid.length;
    const cols = grid[0].length;
    let maxArea = 0;

    const dfs = (i, j) => {
        // Verificar límites y si la celda es agua
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] === 0) {
            return 0;
        }

        grid[i][j] = 0; // Marcar la celda como visitada
        let area = 1; // Contar la celda actual

        // Explorar las 4 direcciones
        area += dfs(i + 1, j); // Abajo
        area += dfs(i - 1, j); // Arriba
        area += dfs(i, j + 1); // Derecha
        area += dfs(i, j - 1); // Izquierda

        return area;
    };

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (grid[i][j] === 1) {
                maxArea = Math.max(maxArea, dfs(i, j)); // Calcular el área de la isla
            }
        }
    }

    return maxArea;
};