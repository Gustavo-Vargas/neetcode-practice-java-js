// 1700. Number of Students Unable to Eat Lunch
/* Instrucctions: 
  La cafetería del colegio ofrece bocadillos circulares y cuadrados a 
    la hora del almuerzo, denominados con los números 0 y 1 respectivamente. 
    Todos los alumnos hacen cola. Cada alumno prefiere los bocadillos 
    cuadrados o circulares.

  El número de bocadillos de la cafetería es igual al número de alumnos. 
    Los bocadillos se colocan en una pila. A cada paso:

  Si el alumno que está al principio de la cola prefiere el bocadillo de la 
   parte superior de la pila, lo cogerá y abandonará la cola.
   Si no, lo dejará y se irá al final de la cola.
  Esto continúa hasta que ninguno de los estudiantes de la cola quiere coger 
   el bocadillo de arriba y por lo tanto no pueden comer.

  Se dan dos matrices enteras estudiantes y bocadillos donde bocadillos[i] es el 
   tipo del bocadillo i-ésimo de la pila (i = 0 es el primero de la pila) y 
   estudiantes[j] es la preferencia del estudiante j-ésimo de la cola inicial 
   (j = 0 es el primero de la cola). Devuelve el número de alumnos que no pueden comer.


*/

/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let count = 0; // Contador para rastrear ciclos sin cambios

    while (students.length > 0) {
        if (students[0] === sandwiches[0]) {
            // El estudiante toma el sándwich
            students.shift(); // Elimina al estudiante del frente
            sandwiches.shift(); // Elimina el sándwich de la pila
            count = 0; // Reinicia el contador
        } else {
            // El estudiante no toma el sándwich, se mueve al final de la cola
            students.push(students.shift());
            count++;
        }

        // Si todos los estudiantes han pasado sin tomar el sándwich, terminamos
        if (count === students.length) {
            break;
        }
    }

    return students.length; // Los estudiantes restantes no pueden comer
};


// 225. Implement Stack using Queues
/* Instrucciones:
Implementa una pila del tipo último en entrar, primero en salir (LIFO) utilizando sólo dos colas. La pila implementada debe soportar todas las funciones de una pila normal (push, top, pop y empty).

Implementar la clase MyStack:
 - void push(int x) Empuja el elemento x a la parte superior de la pila.
 - int pop() Elimina el elemento en la parte superior de la pila y lo devuelve.
 - int top() Devuelve el elemento en la parte superior de la pila.
 - boolean empty() Devuelve true si la pila está vacía, false en caso contrario.
*/
class MyStack {
    constructor() {
        this.queue = [];
    }

    push(x) {
        this.queue.push(x);
        let size = this.queue.length;
        while (size > 1) {
            this.queue.push(this.queue.shift());
            size--;
        }
    }

    pop() {
        return this.queue.shift();
    }

    top() {
        return this.queue[0];
    }

    empty() {
        return this.queue.length === 0;
    }
}

