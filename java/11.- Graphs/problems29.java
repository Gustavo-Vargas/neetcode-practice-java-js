// 200. Number of Islands
/* Instrucciones: 
Dada una m x n cuadrícula binaria 2D que representa un mapa de '1's (tierra) 
  y '0's (agua), devuelva el número de islas.

Una isla está rodeada de agua y se forma conectando tierras adyacentes 
  horizontal o verticalmente. Puede suponer que los cuatro bordes de la 
  cuadrícula están rodeados de agua.
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j); // Realizar DFS para marcar la isla
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        // Verificar límites y si la celda es agua
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Marcar la celda como visitada

        // Explorar las 4 direcciones
        dfs(grid, i + 1, j); // Abajo
        dfs(grid, i - 1, j); // Arriba
        dfs(grid, i, j + 1); // Derecha
        dfs(grid, i, j - 1); // Izquierda
    }
}


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
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j)); // Calcular el área de la isla
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        // Verificar límites y si la celda es agua
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // Marcar la celda como visitada
        int area = 1; // Contar la celda actual

        // Explorar las 4 direcciones
        area += dfs(grid, i + 1, j); // Abajo
        area += dfs(grid, i - 1, j); // Arriba
        area += dfs(grid, i, j + 1); // Derecha
        area += dfs(grid, i, j - 1); // Izquierda

        return area;
    }
}


