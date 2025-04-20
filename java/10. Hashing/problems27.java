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
    private final int SIZE = 1000; // Tamaño del array base
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>(); // Inicializar cada bucket como una lista enlazada
        }
    }

    private int hash(int key) {
        return key % SIZE; // Función hash simple
    }

    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key); // Agregar la clave si no existe
        }
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove((Integer) key); // Eliminar la clave si existe
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key); // Verificar si la clave existe
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
    private final int SIZE = 1000; // Tamaño del array base
    private LinkedList<Entry>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>(); // Inicializar cada bucket como una lista enlazada
        }
    }

    private int hash(int key) {
        return key % SIZE; // Función hash simple
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value; // Actualizar el valor si la clave ya existe
                return;
            }
        }

        bucket.add(new Entry(key, value)); // Agregar un nuevo par clave-valor
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value; // Devolver el valor si se encuentra la clave
            }
        }

        return -1; // Devolver -1 si la clave no existe
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry); // Eliminar el par clave-valor si se encuentra
                return;
            }
        }
    }

    private static class Entry {
        int key, value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
