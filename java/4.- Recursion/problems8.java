// 225. Implement Stack using Queues
/* Instrucciones:
Implementa una pila del tipo último en entrar, primero en salir (LIFO) utilizando sólo dos colas. La pila implementada debe soportar todas las funciones de una pila normal (push, top, pop y empty).

Implementar la clase MyStack:
 - void push(int x) Empuja el elemento x a la parte superior de la pila.
 - int pop() Elimina el elemento en la parte superior de la pila y lo devuelve.
 - int top() Devuelve el elemento en la parte superior de la pila.
 - boolean empty() Devuelve true si la pila está vacía, false en caso contrario.
*/
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Caso base
        }

        ListNode reversedHead = reverseList(head.next); // Invertir el resto de la lista
        head.next.next = head; // Cambiar el puntero del siguiente nodo
        head.next = null; // Eliminar el puntero hacia adelante

        return reversedHead; // Nuevo head de la lista invertida
    }
}