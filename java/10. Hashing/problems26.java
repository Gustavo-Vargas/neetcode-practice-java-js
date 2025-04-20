// 217. Contains Duplicate
/* Instrucciones: 
Dada una matriz de enteros nums, devuelve verdadero si algún valor aparece al menos 
dos veces en la matriz, y devuelve falso si cada elemento es distinto.
*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Encontramos un duplicado
            }
            seen.add(num); // Agregar el número al conjunto
        }

        return false; // No se encontraron duplicados
    }
}


// 1. Two Sum
/* Instrucciones: 
Dado un array de enteros nums y un entero target, devolver los índices de los 
   dos números tales que sumen target.

Puede suponer que cada entrada tendría exactamente una solución, y no puede 
   utilizar el mismo elemento dos veces.

Puede devolver la respuesta en cualquier orden.

*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // HashMap para almacenar números y sus índices

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Devolver los índices
            }
            map.put(nums[i], i); // Almacenar el número y su índice
        }

        return new int[0]; // No debería llegar aquí porque siempre hay una solución
    }
}


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
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Nodo ficticio al inicio
        this.tail = new Node(0, 0); // Nodo ficticio al final
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1; // Si la clave no existe, devolver -1
        Node node = map.get(key);
        remove(node); // Eliminar el nodo de su posición actual
        add(node); // Mover el nodo al frente (más recientemente usado)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); // Eliminar el nodo existente
        }
        Node newNode = new Node(key, value);
        add(newNode); // Agregar el nuevo nodo al frente
        map.put(key, newNode);

        if (map.size() > capacity) {
            Node lru = tail.prev; // Nodo menos recientemente usado
            remove(lru); // Eliminar el nodo LRU
            map.remove(lru.key); // Eliminar la clave del HashMap
        }
    }

    private void remove(Node node) {
        // Eliminar un nodo de la lista doblemente enlazada
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node) {
        // Agregar un nodo al frente de la lista doblemente enlazada
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}