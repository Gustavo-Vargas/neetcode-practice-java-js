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
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(val);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
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

public class BrowserHistory {
    private ArrayList<String> history; // Lista para almacenar el historial
    private int currentIndex; // Índice actual en el historial

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage); // Agrega la página de inicio
        currentIndex = 0; // Inicializa el índice actual
    }

    public void visit(String url) {
        // Borra todo el historial de adelante
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url); // Agrega la nueva URL
        currentIndex++; // Actualiza el índice actual
    }

    public String back(int steps) {
        // Retrocede hasta un máximo de `steps` pasos
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex); // Devuelve la URL actual
    }

    public String forward(int steps) {
        // Avanza hasta un máximo de `steps` pasos
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex); // Devuelve la URL actual
    }
}