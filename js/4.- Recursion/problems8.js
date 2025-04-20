// 206. Reverse Linked List
/* Instrucciones: 
 Dada la cabeza de una lista enlazada, invierte la lista y devuelve la lista invertida.
*/
var reverseListRecursive = function(head) {
    if (head === null || head.next === null) {
        return head; // Caso base
    }

    const reversedHead = reverseListRecursive(head.next); // Invertir el resto de la lista
    head.next.next = head; // Cambiar el puntero del siguiente nodo
    head.next = null; // Eliminar el puntero hacia adelante

    return reversedHead; // Nuevo head de la lista invertida
};