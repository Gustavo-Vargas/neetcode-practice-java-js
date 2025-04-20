// 217. Contains Duplicate
/* Instrucciones: 
Dada una matriz de enteros nums, devuelve verdadero si algún valor aparece al menos 
dos veces en la matriz, y devuelve falso si cada elemento es distinto.
*/
var containsDuplicate = function(nums) {
    const seen = new Set();

    for (const num of nums) {
        if (seen.has(num)) {
            return true; // Encontramos un duplicado
        }
        seen.add(num); // Agregar el número al conjunto
    }

    return false; // No se encontraron duplicados
};


// 1. Two Sum
/* Instrucciones: 
Dado un array de enteros nums y un entero target, devolver los índices de los 
   dos números tales que sumen target.

Puede suponer que cada entrada tendría exactamente una solución, y no puede 
   utilizar el mismo elemento dos veces.

Puede devolver la respuesta en cualquier orden.

*/
var twoSum = function(nums, target) {
    const map = new Map(); // HashMap para almacenar números y sus índices

    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (map.has(complement)) {
            return [map.get(complement), i]; // Devolver los índices
        }
        map.set(nums[i], i); // Almacenar el número y su índice
    }

    return []; // No debería llegar aquí porque siempre hay una solución
};





// 164. LRU Cache
/* Instrucciones: 
Diseñar una estructura de datos que siga las restricciones de una caché 
   LRU (Least Recently Used).

Implementa la clase LRUCache:
 - LRUCache(int capacity) Inicializa la caché LRU con capacidad de tamaño positivo.
 - int get(int key) Devuelve el valor de la clave si la clave existe, en caso 
       contrario devuelve -1.
 - void put(int key, int value) Actualiza el valor de la clave si la clave existe. 
       En caso contrario, añade el par clave-valor a la caché. Si el número de 
       claves supera la capacidad de esta operación, desaloja la clave utilizada 
       menos recientemente.
 - Las funciones get y put deben ejecutarse cada una con una complejidad temporal
       media de O(1).

*/
class Node {
    constructor(key, value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.map = new Map(); // HashMap para acceso rápido
        this.head = new Node(0, 0); // Nodo ficticio al inicio
        this.tail = new Node(0, 0); // Nodo ficticio al final
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    get(key) {
        if (!this.map.has(key)) return -1; // Si la clave no existe, devolver -1
        const node = this.map.get(key);
        this._remove(node); // Eliminar el nodo de su posición actual
        this._add(node); // Mover el nodo al frente (más recientemente usado)
        return node.value;
    }

    put(key, value) {
        if (this.map.has(key)) {
            this._remove(this.map.get(key)); // Eliminar el nodo existente
        }
        const newNode = new Node(key, value);
        this._add(newNode); // Agregar el nuevo nodo al frente
        this.map.set(key, newNode);

        if (this.map.size > this.capacity) {
            const lru = this.tail.prev; // Nodo menos recientemente usado
            this._remove(lru); // Eliminar el nodo LRU
            this.map.delete(lru.key); // Eliminar la clave del HashMap
        }
    }

    _remove(node) {
        // Eliminar un nodo de la lista doblemente enlazada
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    _add(node) {
        // Agregar un nodo al frente de la lista doblemente enlazada
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
}
