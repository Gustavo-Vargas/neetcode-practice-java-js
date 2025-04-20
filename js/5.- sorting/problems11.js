// 23.Merge K sorted Lists
/* Instrucciones: 
Se le da un array de k listas enlazadas, cada lista enlazada está ordenada en orden ascendente.

Fusiona todas las listas enlazadas en una lista enlazada ordenada y devuélvela.
*/
class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

var mergeKLists = function(lists) {
    if (!lists || lists.length === 0) return null;

    // Función para fusionar dos listas enlazadas ordenadas
    const mergeTwoLists = (l1, l2) => {
        let dummy = new ListNode(-1);
        let current = dummy;

        while (l1 !== null && l2 !== null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = l1 !== null ? l1 : l2;
        return dummy.next;
    };

    // Divide y vencerás para fusionar las listas
    const merge = (lists, left, right) => {
        if (left === right) return lists[left];
        const mid = Math.floor((left + right) / 2);
        const l1 = merge(lists, left, mid);
        const l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    };

    return merge(lists, 0, lists.length - 1);
};