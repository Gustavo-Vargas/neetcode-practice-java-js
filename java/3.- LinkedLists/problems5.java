//  206. Reverse Linked List
/* Instrucciones:
    Dada la cabeza de una lista enlazada, invierte la lista y devuelve la nueva cabeza.
    Ejemplo:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
    
    Constraints:
    El número de nodos en la lista es el rango [0, 5000].
    -5000 <= Node.val <= 5000
*/
class Solution {
    public ListNode reverseList(ListNode head) {
       
        ListNode prev = null; // Nodo anterior
        ListNode current = head; // Nodo actual

        while (current != null) {
            ListNode next = current.next; // Guardar el siguiente nodo
            current.next = prev; // Invertir el puntero
            prev = current; // Avanzar prev
            current = next; // Avanzar current
        }
        return prev; // Nuevo head de la lista invertida
        
    }
}

//  21. Merge Two Sorted Lists
/* Instrucciones:
    Dadas dos listas enlazadas ordenadas, combina ambas listas en una sola lista ordenada.
    La lista combinada debe ser el resultado de unir los nodos de las dos listas originales.
    Ejemplo:
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    
    Constraints:
    Las listas enlazadas l1 y l2 están ordenadas en orden no decreciente.
    El número total de nodos en ambas listas es el rango [0, 50].
    -100 <= Node.val <= 100
    
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode aux = new ListNode(-1); 
        ListNode current = aux; // Nodo actual

        while (list1 != null && list1 != null) {
            if (list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        
        return aux.next;
    }
}
