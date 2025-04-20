// 701. Insert into a Binary Search Tree
/* Instrucciones: 
Se le da el nodo raíz de un árbol binario de búsqueda (BST) y un 
valor para insertar en el árbol. Devuelve el nodo raíz del BST 
después de la inserción. Se garantiza que el nuevo valor no existe 
en el BST original.

Tenga en cuenta que pueden existir múltiples formas válidas para la 
inserción, siempre y cuando el árbol siga siendo un BST después de la 
inserción. Puede devolver cualquiera de ellas.
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var insertIntoBST = function(root, val) {
    if (!root) {
        return new TreeNode(val); // Si el árbol está vacío, crea un nuevo nodo
    }

    if (val < root.val) {
        root.left = insertIntoBST(root.left, val); // Insertar en el subárbol izquierdo
    } else {
        root.right = insertIntoBST(root.right, val); // Insertar en el subárbol derecho
    }

    return root; // Devuelve la raíz del árbol actualizado
};




// 405. Delete Node in a BST
/* Instrucciones: 
Dada una referencia al nodo raíz de un BST y una clave, 
  elimina el nodo con la clave dada en el BST. Devuelve la 
  referencia del nodo raíz (posiblemente actualizada) del BST.

Básicamente, la eliminación puede dividirse en dos etapas:
 - Buscar un nodo para eliminarlo.
 - Si se encuentra el nodo, eliminar el nodo.
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var deleteNode = function(root, key) {
    if (!root) return null; // Si el árbol está vacío o no se encuentra el nodo

    if (key < root.val) {
        root.left = deleteNode(root.left, key); // Buscar en el subárbol izquierdo
    } else if (key > root.val) {
        root.right = deleteNode(root.right, key); // Buscar en el subárbol derecho
    } else {
        // Caso 1: El nodo no tiene hijos
        if (!root.left && !root.right) {
            return null;
        }

        // Caso 2: El nodo tiene un solo hijo
        if (!root.left) {
            return root.right;
        }
        if (!root.right) {
            return root.left;
        }

        // Caso 3: El nodo tiene dos hijos
        let successor = findMin(root.right); // Encuentra el sucesor en orden
        root.val = successor.val; // Reemplaza el valor del nodo con el sucesor
        root.right = deleteNode(root.right, successor.val); // Elimina el sucesor
    }

    return root;
};

// Función para encontrar el nodo más pequeño en un subárbol
const findMin = (node) => {
    while (node.left) {
        node = node.left;
    }
    return node;
};
