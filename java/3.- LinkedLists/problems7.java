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

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student); // Agregar estudiantes a la cola
        }

        int sandwichIndex = 0; // Índice para rastrear el sándwich en la parte superior
        int count = 0; // Contador para rastrear ciclos sin cambios

        while (!studentQueue.isEmpty()) {
            if (studentQueue.peek() == sandwiches[sandwichIndex]) {
                // El estudiante toma el sándwich
                studentQueue.poll(); // Elimina al estudiante del frente
                sandwichIndex++; // Avanza al siguiente sándwich
                count = 0; // Reinicia el contador
            } else {
                // El estudiante no toma el sándwich, se mueve al final de la cola
                studentQueue.add(studentQueue.poll());
                count++;
            }

            // Si todos los estudiantes han pasado sin tomar el sándwich, terminamos
            if (count == studentQueue.size()) {
                break;
            }
        }

        return studentQueue.size(); // Los estudiantes restantes no pueden comer
    }
}


// 225. Implement Stack using Queues
/* Instrucciones:
Implementa una pila del tipo último en entrar, primero en salir (LIFO) utilizando sólo dos colas. La pila implementada debe soportar todas las funciones de una pila normal (push, top, pop y empty).

Implementar la clase MyStack:
 - void push(int x) Empuja el elemento x a la parte superior de la pila.
 - int pop() Elimina el elemento en la parte superior de la pila y lo devuelve.
 - int top() Devuelve el elemento en la parte superior de la pila.
 - boolean empty() Devuelve true si la pila está vacía, false en caso contrario.
*/
public class MyStack {
    private Queue<Integer> queue1; // Cola principal
    private Queue<Integer> queue2; // Cola auxiliar

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // Agregar el nuevo elemento a la cola auxiliar
        queue2.add(x);
        // Mover todos los elementos de queue1 a queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        // Intercambiar las referencias de queue1 y queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll(); // Eliminar y devolver el elemento al frente de queue1
    }

    public int top() {
        return queue1.peek(); // Devolver el elemento al frente de queue1 sin eliminarlo
    }

    public boolean empty() {
        return queue1.isEmpty(); // Verificar si queue1 está vacía
    }
}

