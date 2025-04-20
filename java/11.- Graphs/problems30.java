// 1091. Shortest Path in Binary Matrix
/* Instrucciones: 
Dada una rejilla de matriz binaria n x n, devuelve la longitud del 
   camino despejado más corto de la matriz. Si no hay camino 
   libre, devuelve -1.

Un camino despejado en una matriz binaria es un camino desde la 
   celda superior izquierda (es decir, (0, 0)) hasta la celda 
   inferior derecha (es decir, (n - 1, n - 1)) tal que:

 - Todas las celdas visitadas del camino son 0.
 - Todas las celdas adyacentes del camino están conectadas en 
     8 direcciones (es decir, son diferentes y comparten una arista o una esquina).

La longitud de un camino despejado es el número de celdas visitadas de este camino.
*/
public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Si la celda inicial o final no es transitable, no hay camino
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // Direcciones para moverse en 8 direcciones
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        // Cola para BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // Iniciar desde la celda (0, 0)
        grid[0][0] = 1; // Marcar como visitada (usamos el valor como distancia)

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            int distance = grid[row][col];

            // Si llegamos a la celda final, devolvemos la distancia
            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            // Explorar las 8 direcciones
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Verificar límites y si la celda es transitable
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = distance + 1; // Marcar como visitada con la distancia
                }
            }
        }

        return -1; // No hay camino
    }

}



// 994. Rotting Oranges
/* Instrucciones: 
Se le da una cuadrícula de m x n en la que cada celda puede 
tener uno de tres valores:

- 0 que representa una celda vacía,
- 1 que representa una naranja fresca, o
- 2 que representa una naranja podrida.

Cada minuto, cualquier naranja fresca que sea 4-direccionalmente adyacente 
a una naranja podrida se convierte en podrida.

Devuelve el número mínimo de minutos que deben transcurrir hasta que 
ninguna celda tenga una naranja fresca. Si es imposible, devuelve -1.
*/
public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0} // Direcciones: derecha, abajo, izquierda, arriba
        };

        // Inicializar la cola con las naranjas podridas y contar las frescas
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j}); // Agregar naranjas podridas a la cola
                } else if (grid[i][j] == 1) {
                    freshCount++; // Contar naranjas frescas
                }
            }
        }

        if (freshCount == 0) return 0; // Si no hay naranjas frescas, devolver 0

        int minutes = 0;

        // BFS para propagar el estado de podrido
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Verificar límites y si la celda contiene una naranja fresca
                    if (
                        newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1
                    ) {
                        grid[newRow][newCol] = 2; // Pudrir la naranja fresca
                        queue.add(new int[]{newRow, newCol}); // Agregarla a la cola
                        freshCount--; // Reducir el conteo de naranjas frescas
                        hasRotten = true;
                    }
                }
            }

            if (hasRotten) minutes++; // Incrementar el tiempo si hubo propagación
        }

        return freshCount == 0 ? minutes : -1; // Si quedan naranjas frescas, devolver -1
    }
}



