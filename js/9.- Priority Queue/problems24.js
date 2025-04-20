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
class MinHeap {
  constructor() {
      this.heap = [];
  }

  push(val) {
      this.heap.push(val);
      this.bubbleUp();
  }

  pop() {
      if (this.size() === 1) return this.heap.pop();
      const top = this.heap[0];
      this.heap[0] = this.heap.pop();
      this.bubbleDown();
      return top;
  }

  peek() {
      return this.heap[0];
  }

  size() {
      return this.heap.length;
  }

  bubbleUp() {
      let index = this.heap.length - 1;
      while (index > 0) {
          const parentIndex = Math.floor((index - 1) / 2);
          if (this.heap[index] >= this.heap[parentIndex]) break;
          [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
          index = parentIndex;
      }
  }

  bubbleDown() {
      let index = 0;
      const length = this.heap.length;
      while (true) {
          const leftChildIndex = 2 * index + 1;
          const rightChildIndex = 2 * index + 2;
          let smallest = index;

          if (leftChildIndex < length && this.heap[leftChildIndex] < this.heap[smallest]) {
              smallest = leftChildIndex;
          }
          if (rightChildIndex < length && this.heap[rightChildIndex] < this.heap[smallest]) {
              smallest = rightChildIndex;
          }
          if (smallest === index) break;
          [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
          index = smallest;
      }
  }
}

class KthLargest {
  constructor(k, nums) {
      this.k = k;
      this.minHeap = new MinHeap();

      for (const num of nums) {
          this.add(num);
      }
  }

  add(val) {
      this.minHeap.push(val);
      if (this.minHeap.size() > this.k) {
          this.minHeap.pop();
      }
      return this.minHeap.peek();
  }
}




