// 1046. Last Stone Weight
/* Instrucciones: 
Se le da una matriz de enteros piedras donde piedras[i] es el peso de la ith piedra.

Jugamos a un juego con las piedras. En cada turno, elegimos las dos piedras más pesadas 
   y las hacemos chocar. Supongamos que las dos piedras más pesadas tienen pesos x e y 
   con x &lt;= y. El resultado de este choque es:

 - Si x == y, ambas piedras se destruyen, y
 - Si x != y, la piedra de peso x se destruye, y la piedra de peso y tiene nuevo peso y - x.

Al final del juego, queda como máximo una piedra.

Devuelve el peso de la última piedra que queda. Si no queda ninguna piedra, devuelve 0.

*/
public class Solution {
    public int lastStoneWeight(int[] stones) {
        // Usamos un max-heap (cola de prioridad máxima)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insertar todas las piedras en el max-heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Simular el juego
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Piedra más pesada
            int stone2 = maxHeap.poll(); // Segunda piedra más pesada

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // Insertar la diferencia
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll(); // Devolver la última piedra o 0
    }
}


// 973. K Closest Points to Origin
/* Instrucciones: 
Dada una matriz de puntos donde puntos[i] = [xi, yi] representa un punto en el plano X-Y 
  y un número entero k, devuelve los k puntos más cercanos al origen (0, 0).

La distancia entre dos puntos del plano X-Y es la distancia euclídea 
  (es decir, √(x1 - x2)2 + (y1 - y2)2).

Puede devolver la respuesta en cualquier orden. Se garantiza que la respuesta es única 
  (excepto en el orden en que se encuentre).

*/
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Usamos un max-heap (cola de prioridad máxima)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int[] point : points) {
            int x = point[0], y = point[1];
            int distance = x * x + y * y; // Distancia al cuadrado
            maxHeap.offer(new int[]{distance, x, y});
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Eliminar el punto más lejano si el tamaño del heap excede k
            }
        }

        // Construir el resultado
        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            int[] entry = maxHeap.poll();
            result[index++] = new int[]{entry[1], entry[2]};
        }

        return result;
    }
}



// 215. Kth Largest Element in an Array
/* Instrucciones: 
Dado un array entero nums y un entero k, devuelve el k-ésimo elemento más grande del array.

Tenga en cuenta que es el k-ésimo elemento más grande en el orden, no el 
  k-ésimo elemento distinto.

*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Usamos un min-heap (cola de prioridad mínima)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Mantener el tamaño del heap en k
            }
        }

        return minHeap.peek(); // La raíz del heap es el k-ésimo elemento más grande
    }
}
