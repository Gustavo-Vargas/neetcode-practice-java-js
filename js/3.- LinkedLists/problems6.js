// 707. Design Linked List
/* Instrucctions:
 Diseña tu implementación de la lista enlazada. Puedes elegir utilizar una 
   lista simple o doblemente enlazada.
 Un nodo en una lista enlazada simple debe tener dos atributos: val y next. 
   val es el valor del nodo actual, y next es un puntero/referencia al siguiente nodo.
 Si desea utilizar la lista doblemente enlazada, necesitará un atributo más prev
   para indicar el nodo anterior en la lista enlazada. Supongamos que todos los nodos de 
   la lista enlazada tienen índice 0.
    Implementa los métodos de la lista enlazada:
    - get(index): obtiene el valor del nodo en la posición index de la lista enlazada.
    - addAtHead(val): agrega un nodo con valor val al inicio de la lista enlazada.
    - addAtTail(val): agrega un nodo con valor val al final de la lista enlazada.
    - addAtIndex(index, val): agrega un nodo con valor val en la posición index de la lista enlazada. Si index es igual a la longitud de la lista, se agrega al final. Si index es mayor que la longitud de la lista, no se hace nada.
    - deleteAtIndex(index): elimina el nodo en la posición index de la lista enlazada.
    
*/
class Node {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    constructor() {
        this.head = null; // Puntero al primer nodo
        this.size = 0; // Tamaño de la lista
    }

    get(index) {
        if (index < 0 || index >= this.size) return -1;
        let current = this.head;
        for (let i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    addAtHead(val) {
        const newNode = new Node(val, this.head);
        this.head = newNode;
        this.size++;
    }

    addAtTail(val) {
        const newNode = new Node(val);
        if (!this.head) {
            this.head = newNode;
        } else {
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    addAtIndex(index, val) {
        if (index < 0 || index > this.size) return;
        if (index === 0) {
            this.addAtHead(val);
        } else {
            let current = this.head;
            for (let i = 0; i < index - 1; i++) {
                current = current.next;
            }
            const newNode = new Node(val, current.next);
            current.next = newNode;
            this.size++;
        }
    }

    deleteAtIndex(index) {
        if (index < 0 || index >= this.size) return;
        if (index === 0) {
            this.head = this.head.next;
        } else {
            let current = this.head;
            for (let i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        this.size--;
    }
}


// 1472. Design Browser History
/* Instrucctions: 
   Tienes un navegador de una pestaña donde empiezas en la página principal y puedes visitar otra url, 
      retroceder en el historial número de pasos o avanzar en el historial número de pasos.
   Implementa la clase BrowserHistory:ard(steps): 
    - BrowserHistory(string homepage) Inicializa el objeto con la página de inicio del navegador.
    - visit(string url) Visita la url de la página actual. Borra todo el historial hacia adelante.
    - string back(int steps) Mueve los pasos hacia atrás en el historial. Si sólo puede devolver 
       x pasos en el historial y pasos > x, devolverá sólo x pasos. Devuelve la url actual después
       de retroceder como máximo pasos en el historial.
    - string forward(int steps) Mueve pasos hacia adelante en el historial. Si sólo puede avanzar 
       x pasos en la historia y pasos > x, avanzará sólo x pasos. Devuelve la url actual después 
       de avanzar en la historia como máximo pasos.
*/

class BrowserHistory {
    constructor(homepage) {
        this.history = [homepage]; // Arreglo para almacenar el historial
        this.currentIndex = 0; // Índice actual en el historial
    }

    visit(url) {
        // Borra todo el historial de adelante
        this.history = this.history.slice(0, this.currentIndex + 1);
        this.history.push(url); // Agrega la nueva URL
        this.currentIndex++; // Actualiza el índice actual
    }

    back(steps) {
        // Retrocede hasta un máximo de `steps` pasos
        this.currentIndex = Math.max(0, this.currentIndex - steps);
        return this.history[this.currentIndex]; // Devuelve la URL actual
    }

    forward(steps) {
        // Avanza hasta un máximo de `steps` pasos
        this.currentIndex = Math.min(this.history.length - 1, this.currentIndex + steps);
        return this.history[this.currentIndex]; // Devuelve la URL actual
    }
}
