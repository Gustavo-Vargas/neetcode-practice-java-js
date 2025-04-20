// 705. Design HashSet
/* Instrucciones: 
Diseña un HashSet sin utilizar ninguna librería de tablas hash.

Implementa la clase MyHashSet:
 - void add(key) Inserta la clave de valor en el HashSet.
 - bool contains(key) Devuelve si la clave de valor existe o no en el HashSet.
 - void remove(key) Elimina la clave de valor en el HashSet. Si la 
    clave no existe en el HashSet, no hace nada.
*/
class MyHashSet {
    constructor() {
        this.SIZE = 1000; // Tamaño del array base
        this.buckets = Array.from({ length: this.SIZE }, () => new Set()); // Inicializar buckets como conjuntos
    }

    _hash(key) {
        return key % this.SIZE; // Función hash simple
    }

    add(key) {
        const index = this._hash(key);
        this.buckets[index].add(key); // Agregar la clave al bucket correspondiente
    }

    remove(key) {
        const index = this._hash(key);
        this.buckets[index].delete(key); // Eliminar la clave del bucket correspondiente
    }

    contains(key) {
        const index = this._hash(key);
        return this.buckets[index].has(key); // Verificar si la clave existe en el bucket
    }
}


// 706. Desgn HashMap
/* Instrucciones: 
Diseñar un HashMap sin utilizar ninguna librería de tablas hash incorporada.

Implementa la clase MyHashMap:
 - MyHashMap() inicializa el objeto con un mapa vacío.
 - void put(int key, int value) inserta un par (clave, valor) en el HashMap. 
     Si la clave ya existe en el mapa, actualiza el valor correspondiente.
 - int get(int key) devuelve el valor al que está asignada la clave especificada, 
     o -1 si este mapa no contiene ninguna asignación para la clave.
 - void remove(key) elimina la clave y su valor correspondiente si el mapa 
     contiene la asignación para la clave.
*/
class MyHashMap {
    constructor() {
        this.SIZE = 1000; // Tamaño del array base
        this.buckets = Array.from({ length: this.SIZE }, () => []); // Inicializar buckets como listas
    }

    _hash(key) {
        return key % this.SIZE; // Función hash simple
    }

    put(key, value) {
        const index = this._hash(key);
        const bucket = this.buckets[index];

        for (let i = 0; i < bucket.length; i++) {
            if (bucket[i][0] === key) {
                bucket[i][1] = value; // Actualizar el valor si la clave ya existe
                return;
            }
        }

        bucket.push([key, value]); // Agregar un nuevo par clave-valor
    }

    get(key) {
        const index = this._hash(key);
        const bucket = this.buckets[index];

        for (const [k, v] of bucket) {
            if (k === key) {
                return v; // Devolver el valor si se encuentra la clave
            }
        }

        return -1; // Devolver -1 si la clave no existe
    }

    remove(key) {
        const index = this._hash(key);
        const bucket = this.buckets[index];

        for (let i = 0; i < bucket.length; i++) {
            if (bucket[i][0] === key) {
                bucket.splice(i, 1); // Eliminar el par clave-valor si se encuentra
                return;
            }
        }
    }
}

