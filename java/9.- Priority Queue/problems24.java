// 703. Kth Largest Element in a Stream
/* Instrucciones: 
Usted forma parte de la oficina de admisiones de una universidad y necesita realizar 
  un seguimiento en tiempo real de la k-ésima puntuación más alta de los solicitantes. 
  Esto ayuda a determinar las notas de corte para las entrevistas y las admisiones de 
  forma dinámica a medida que los nuevos solicitantes envían sus puntuaciones.

Se le pide que implemente una clase que, para un número entero k dado, mantenga un 
  flujo de puntuaciones de exámenes y devuelva continuamente la k-ésima puntuación 
  más alta después de que se haya enviado una nueva puntuación. Más concretamente, 
  buscamos la k-ésima puntuación más alta de la lista ordenada de todas las puntuaciones.

Implementa la clase KthLargest:
  - KthLargest(int k, int[] nums) Inicializa el objeto con el número entero k y 
      el flujo de puntuaciones de test nums.
  - int add(int val) Añade una nueva puntuación de test val al flujo y devuelve
      el elemento que representa la k-ésima puntuación más alta del conjunto de puntuaciones de test hasta el momento.
*/
public class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll(); // Eliminar el elemento más pequeño si el tamaño del heap excede k
        }
        return minHeap.peek(); // La raíz del heap es el k-ésimo elemento más grande
    }

    // Ejemplo de uso:
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
}

