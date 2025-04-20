// 700. Search in a Binary Search Tree
/* Instrucciones: 
Se le da la raíz de un árbol de búsqueda binario (BST) y un entero val.

Encuentra el nodo en el BST que el valor del nodo es igual a val y devuelve 
l subárbol enraizado con ese nodo. Si dicho nodo no existe, devuelve null.
*/

class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var searchBST = function(root, val) {
    if (!root) return null; // Si el nodo es null, no existe el valor

    if (root.val === val) {
        return root; // Encontramos el nodo
    } else if (val < root.val) {
        return searchBST(root.left, val); // Buscar en el subárbol izquierdo
    } else {
        return searchBST(root.right, val); // Buscar en el subárbol derecho
    }
};





// 235. Lowest Common Ancestor of a Binary Search Tree
/* Instrucciones: 
Dado un árbol binario de búsqueda (BST), encuentre el nodo de ancestro 
   común más bajo (LCA) de dos nodos dados en el BST.

Según la definición de LCA en Wikipedia "El ancestro común más bajo 
   se define entre dos nodos p y q como el nodo más bajo en T que tiene 
   tanto p como q como descendientes (donde permitimos que un nodo 
   sea descendiente de sí mismo)."
*/


class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var lowestCommonAncestor = function(root, p, q) {
    if (!root) return null;

    // Si ambos nodos están en el subárbol izquierdo
    if (p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left, p, q);
    }

    // Si ambos nodos están en el subárbol derecho
    if (p.val > root.val && q.val > root.val) {
        return lowestCommonAncestor(root.right, p, q);
    }

    // Si los nodos están en lados opuestos o uno de ellos es el nodo actual
    return root;
};
