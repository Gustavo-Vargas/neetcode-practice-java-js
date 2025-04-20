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
class MaxHeap {
    constructor() {
        this.heap = [];
    }

    push(val) {
        this.heap.push(val);
        this.bubbleUp();
    }

    pop() {
        if (this.size() === 1) return this.heap.pop();
        const max = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return max;
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
            if (this.heap[index] <= this.heap[parentIndex]) break;
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
            let largest = index;

            if (leftChildIndex < length && this.heap[leftChildIndex] > this.heap[largest]) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < length && this.heap[rightChildIndex] > this.heap[largest]) {
                largest = rightChildIndex;
            }
            if (largest === index) break;
            [this.heap[index], this.heap[largest]] = [this.heap[largest], this.heap[index]];
            index = largest;
        }
    }
}

var lastStoneWeight = function(stones) {
    const maxHeap = new MaxHeap();

    // Insertar todas las piedras en el max-heap
    for (const stone of stones) {
        maxHeap.push(stone);
    }

    // Simular el juego
    while (maxHeap.size() > 1) {
        const stone1 = maxHeap.pop(); // Piedra más pesada
        const stone2 = maxHeap.pop(); // Segunda piedra más pesada

        if (stone1 !== stone2) {
            maxHeap.push(stone1 - stone2); // Insertar la diferencia
        }
    }

    return maxHeap.size() === 0 ? 0 : maxHeap.pop(); // Devolver la última piedra o 0
};


// 973. K Closest Points to Origin
/* Instrucciones: 
Dada una matriz de puntos donde puntos[i] = [xi, yi] representa un punto en el plano X-Y 
  y un número entero k, devuelve los k puntos más cercanos al origen (0, 0).

La distancia entre dos puntos del plano X-Y es la distancia euclídea 
  (es decir, √(x1 - x2)2 + (y1 - y2)2).

Puede devolver la respuesta en cualquier orden. Se garantiza que la respuesta es única 
  (excepto en el orden en que se encuentre).

*/
class MaxHeap {
    constructor() {
        this.heap = [];
    }

    push(point) {
        this.heap.push(point);
        this.bubbleUp();
    }

    pop() {
        if (this.size() === 1) return this.heap.pop();
        const max = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return max;
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
            if (this.heap[index][0] <= this.heap[parentIndex][0]) break;
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
            let largest = index;

            if (leftChildIndex < length && this.heap[leftChildIndex][0] > this.heap[largest][0]) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < length && this.heap[rightChildIndex][0] > this.heap[largest][0]) {
                largest = rightChildIndex;
            }
            if (largest === index) break;
            [this.heap[index], this.heap[largest]] = [this.heap[largest], this.heap[index]];
            index = largest;
        }
    }
}

var kClosest = function(points, k) {
    const maxHeap = new MaxHeap();

    for (const [x, y] of points) {
        const distance = x * x + y * y; // Distancia al cuadrado
        maxHeap.push([distance, [x, y]]);
        if (maxHeap.size() > k) {
            maxHeap.pop(); // Eliminar el punto más lejano si el tamaño del heap excede k
        }
    }

    return maxHeap.heap.map((entry) => entry[1]); // Devolver los puntos
};

// 215. Kth Largest Element in an Array
/* Instrucciones: 
Dado un array entero nums y un entero k, devuelve el k-ésimo elemento más grande del array.

Tenga en cuenta que es el k-ésimo elemento más grande en el orden, no el 
  k-ésimo elemento distinto.

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
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return min;
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

var findKthLargest = function(nums, k) {
    const minHeap = new MinHeap();

    for (const num of nums) {
        minHeap.push(num);
        if (minHeap.size() > k) {
            minHeap.pop(); // Mantener el tamaño del heap en k
        }
    }

    return minHeap.peek(); // La raíz del heap es el k-ésimo elemento más grande
};


